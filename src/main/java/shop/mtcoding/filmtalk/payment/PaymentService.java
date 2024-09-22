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
import shop.mtcoding.filmtalk.seat.Seat;
import shop.mtcoding.filmtalk.seat.SeatRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.ticket.Ticket;
import shop.mtcoding.filmtalk.ticket.TicketRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    // 아임포트 결제부분
    @Transactional
    public void save(PaymentRequest.SaveDTO saveDTO) {

        try {
            // 클라이언트가 결제 됐다고 알림 -> SaveDTO로 / 예매ID(reservationId), 가맹점ID(impUid)
            IamportResponse<com.siot.IamportRestClient.response.Payment> iamportResponse = iamportClient.paymentByImpUid(saveDTO.getImpUid());

            // 결제 완료가 아니면
            if(!iamportResponse.getResponse().getStatus().equals("paid")) {
                // 티켓도 2장 삭제

                // 주문&결제 삭제 (예매=부모 삭제하면, 티켓도 삭제 되는지 확인)
                // reservationRepository.deleteById(saveDTO.getReservationId());
                Long reservationId = saveDTO.getReservationId();
                reservationRepository.deleteById(reservationId);
                throw new ExceptionApi500("결제가 완료되지 않았습니다.");
            }

            // 결제 정보 저장
            Reservation reservationPS = reservationRepository.findById(saveDTO.getReservationId())
                    .orElseThrow(() -> new ExceptionApi404("예매 내역을 찾을 수 없습니다."));
            Payment payment = Payment.builder()
                    .price(100.0)
                    .point(0)
                    .state(2) // 결제 완료
                    .cnclDate(null)
                    .payDate(Timestamp.valueOf(LocalDateTime.now()))
                    .impUid(saveDTO.getImpUid())
                    .type("card")
                    .mycoupon(null)
                    .reservation(reservationPS)
                    .build();
            paymentRepository.save(payment);

        } catch (Exception e) {
            throw new ExceptionApi500(e.getMessage());
        }
    }


    // payment/view 페이지 데이터 처리 로직
    public PaymentResponse.PaymentViewDTO getPaymentViewData(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ExceptionApi404("예약 정보를 찾을 수 없습니다."));

        // 중복 티켓 제거
        List<Ticket> tickets = reservation.getTickets().stream()
                .distinct()
                .collect(Collectors.toList());

        if (tickets.isEmpty()) {
            throw new ExceptionApi404("예매된 티켓이 없습니다.");
        }


        Showtime showtime = tickets.get(0).getShowtime(); // 첫번째 티켓의 상영 시간 사용
        Movie movie = showtime.getMovie();

        if (movie == null || movie.getId() == null) {
            throw new IllegalArgumentException("영화 정보가 없습니다.");
        }

        String posterUrl = posterRepository.findPosterUrlByMovieId(movie.getId());
        if (posterUrl == null) {
            throw new IllegalArgumentException("영화 포스터 URL을 찾을 수 없습니다.");
        }


        Screen screen = showtime.getScreen();
        Cinema cinema = screen.getCinema();

        // 중복 좌석 제거
        List<String> seats = tickets.stream()  // 여러 티켓의 좌석 번호를 리스트로 처리
                .map(ticket -> ticket.getSeat().getSeatNumber())
                .distinct()
                .collect(Collectors.toList());


        int people = tickets.size();  // 티켓 개수를 인원수로 사용
        Double totalPrice = (double) people * showtime.getPrice();  // 티켓 수 * 가격

        // DTO 반환
        return new PaymentResponse.PaymentViewDTO(
                reservationId,
                reservation.getUser().getUsername(),
                posterUrl,
                movie.getMovieNm(),
                showtime.getStartedAt(),
                screen.getName(),
                cinema.getName(),
                people,
                seats,
                totalPrice,
                totalPrice
        );
    }

    public Payment getPaymentSuccessById(Long reservationId) {
        return paymentRepository.findByReservationId(reservationId);  // Long 타입 조회
    }

}
