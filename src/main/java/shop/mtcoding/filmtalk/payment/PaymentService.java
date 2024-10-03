package shop.mtcoding.filmtalk.payment;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi500;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.poster.PosterRepository;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.reservation.ReservationRepository;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.seat.SeatRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.ticket.Ticket;
import shop.mtcoding.filmtalk.ticket.TicketRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static shop.mtcoding.filmtalk.seat.SeatResponse.DTO.calculateEndTime;
import static shop.mtcoding.filmtalk.seat.SeatResponse.DTO.convertTimeStampToString;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {

    private final MovieRepository movieRepository;
    private final PosterRepository posterRepository;
    private final ShowtimeRepository showtimeRepository;
    private final ScreenRepository screenRepository;
    private final TicketRepository ticketRepository;
    private final ReservationRepository reservationRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentQueryRepository paymentQueryRepository;
    private final IamportClient iamportClient;
    private final SeatRepository seatRepository;


    // ================ 아임포트 결제부분 ======================
    // 결제 요청 전 고유한 merchant_uid 생성 메소드
    public String generateMerchantUid(Long reservationId) {
        // reservationId와 고유한 UUID를 조합해서 고유한 merchant_uid 생성
        return "reservation_" + reservationId + "_" + UUID.randomUUID().toString();
    }

    // 결제 직후 랜덤 8자리 예매번호 생성
    public String generateBookingNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    // 결제 요청 처리 로직
    @Transactional
    public void save(PaymentRequest.SaveDTO saveDTO) {
        try {
            // 새로운 결제 요청 시 고유한 merchant_uid 생성
            String merchantUid = generateMerchantUid(saveDTO.getReservationId());

            // 클라이언트에서 결제 성공 여부를 확인 -> SaveDTO로
            IamportResponse<com.siot.IamportRestClient.response.Payment> iamportResponse = iamportClient.paymentByImpUid(saveDTO.getImpUid());

            // 결제 완료가 아니면 // 티켓도 2장 삭제
            if(!iamportResponse.getResponse().getStatus().equals("paid")) {
                // 주문&결제 삭제 (예매=부모 삭제하면, 티켓도 삭제 되는지 확인)
                // reservationRepository.deleteById(saveDTO.getReservationId());
                Long reservationId = saveDTO.getReservationId();
                reservationRepository.deleteById(reservationId);
                throw new ExceptionApi500("결제가 완료되지 않았습니다.");
            }

            // 결제 성공 시 예매번호 생성
            String bookingNumber = generateBookingNumber();

            // 만약 bookingNumber가 제대로 생성되지 않았다면 예외 발생
            if (bookingNumber == null || bookingNumber.isEmpty()) {
                throw new ExceptionApi500("예매번호 생성에 실패했습니다.");
            }

            // 예약 정보 조회
            Reservation reservationPS = reservationRepository.findById(saveDTO.getReservationId())
                    .orElseThrow(() -> new ExceptionApi404("예매 내역을 찾을 수 없습니다."));

            // 결제 정보 저장
            Payment payment = Payment.builder()
                    .price(saveDTO.getPrice())
                    .state(2)
                    .cnclDate(null)
                    .payDate(Timestamp.valueOf(LocalDateTime.now()))
                    .impUid(saveDTO.getImpUid())
                    .type("card")
                    .mycoupon(null)
                    .bookingNumber(generateBookingNumber())
                    .reservation(reservationPS)
                    .build();

            paymentRepository.save(payment);

        } catch (Exception e) {
            throw new ExceptionApi500(e.getMessage());
        }
    }

    // =========================================================================

    // payment/view 페이지 데이터 처리 로직
    public PaymentResponse.PaymentViewDTO getPaymentViewData(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ExceptionApi404("예약 정보를 찾을 수 없습니다."));

        // 예약에 해당하는 티켓 목록 가져오기
        List<Ticket> tickets = reservation.getTickets();

        if (tickets.isEmpty()) {
            throw new ExceptionApi404("예매된 티켓이 없습니다.");
        }

        // 첫 번째 티켓을 사용해 상영시간, 영화, 상영관 등의 정보를 가져오기
        Showtime showtime = tickets.getFirst().getShowtime();
        Movie movie = showtime.getMovie();
        Screen screen = showtime.getScreen();
        Cinema cinema = screen.getCinema();
        String email = reservation.getUser().getEmail();
        String phone = reservation.getUser().getPhone();

        // 영화 포스터 URL 가져오기 (poster_tb 테이블 참조) (결과 한건)
        List<String> posterUrl = posterRepository.findPosterUrlByMovieId(movie.getId());

        // 좌석 정보 처리 (티켓을 통해 좌석 번호 가져옴)
        List<String> seatNumbers = tickets.stream()
                .map(ticket -> ticket.getSeat().getSeatNumber())
                .collect(Collectors.toList());
//        List<PaymentResponse.PaymentViewDTO.SeatDTO> seatDTOs = tickets.stream()
//                .map(ticket -> new PaymentResponse.PaymentViewDTO.SeatDTO(
//                        ticket.getSeat().getId(),
//                        ticket.getSeat().getSeatNumber() // 좌석 번호 처리
//                ))
//                .collect(Collectors.toList());

        int people = tickets.size();  // 티켓 개수 = 인원 수 // TODO: seatNumber로 출력
        Integer totalPrice = people * showtime.getPrice(); // 티켓 수 * 가격

        return new PaymentResponse.PaymentViewDTO(
                reservationId,
                reservation.getUser().getUsername(),  // 유저 이름
                reservation.getUser().getEmail(),     // 이메일
                reservation.getUser().getPhone(),     // 전화번호
                showtime.getMovie().getPosterUrls().get(0).getUrl(),  // 영화 포스터 URL
                showtime.getMovie().getMovieNm(),     // 영화 제목
                convertTimeStampToString(Timestamp.valueOf(showtime.getStartedAt().toLocalDateTime()), "yyyy.MM.dd(E) HH:mm"),  // 상영 시작 시간 (전체 날짜와 시간 포함)
                calculateEndTime(Timestamp.valueOf(showtime.getStartedAt().toLocalDateTime()), showtime.getMovie().getRuntime()),  // 종료 시간
                convertTimeStampToString(Timestamp.valueOf(showtime.getStartedAt().toLocalDateTime()), "yyyy.MM.dd(E) HH:mm"),  // 전체 상영 시간 (yyyy.MM.dd HH:mm)
                showtime.getScreen().getCinema().getName(),  // 영화관 이름
                showtime.getScreen().getName(),              // 상영관 이름
                reservation.getTickets().size(),             // 관람 인원 수
                reservation.getTickets().stream()
                        .map(ticket -> ticket.getSeat().getSeatNumber())  // 좌석 목록
                        .collect(Collectors.toList()),
                reservation.getTickets().size() * showtime.getPrice(),  // 총 결제 금액
                reservation.getTickets().size() * showtime.getPrice()   // 결제 금액
        );
    }



    // TODO: 실제 db 조회 후 넘기는 로직
//    public PaymentResponse.PaymentViewDTO getPaymentViewData(Long reservationId) {
//        // Reservation을 조회하여 예외 처리
//        Reservation reservation = reservationRepository.findById(reservationId)
//                .orElseThrow(() -> new ExceptionApi404("예약 정보를 찾을 수 없습니다."));
//
//        // 연결된 Ticket 정보 조회 (Reservation과 연결된 티켓 목록)
//        List<Ticket> tickets = reservation.getTickets();
//
//        // 첫 번째 티켓의 상영 시간 정보
//        Showtime showtime = tickets.get(0).getShowtime();
//        Movie movie = showtime.getMovie();
//
//        // 영화관 및 상영관 정보
//        Screen screen = showtime.getScreen();
//        Cinema cinema = screen.getCinema();
//
//        // 좌석 정보
//        List<String> seats = tickets.stream()
//                .map(ticket -> ticket.getSeat().getSeatNumber())
//                .collect(Collectors.toList());
//
//        // 인원 수는 티켓 개수로 결정
//        int people = tickets.size();
//
//        // 총 결제 금액은 인원 수와 영화의 티켓 가격으로 계산
//        Double totalPrice = (double) people * showtime.getPrice();
//
//        // 실제 데이터를 반환
//        return new PaymentResponse.PaymentViewDTO(
//                reservationId,
//                reservation.getUser().getUsername(),
//                movie.getPosterUrls(),  // 영화 포스터 이미지 URL
//                movie.getMovieNm(),    // 영화 제목
//                showtime.getStartedAt(),  // 상영 시간
//                cinema.getName(),  // 영화관 이름
//                screen.getName(),  // 상영관 이름
//                people,  // 인원 수
//                seats,  // 좌석 목록
//                totalPrice,  // 총 결제 금액
//                totalPrice   // 결제 금액
//        );
//    }



}
