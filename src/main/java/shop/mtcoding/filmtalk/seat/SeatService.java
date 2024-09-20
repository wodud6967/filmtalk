package shop.mtcoding.filmtalk.seat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.reservation.ReservationRepository;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.ticket.TicketRepsoitory;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final SeatQueryRepository seatQueryRepository;
    private final ShowtimeRepository showtimeRepository;
    private final ScreenRepository screenRepository;
    private final TicketRepsoitory ticketRepsoitory;
    private final ReservationRepository reservationRepository;

    public SeatResponse.DTO 좌석메인화면(long id) {

        Showtime showtimePS = showtimeRepository.mFindById(id)
                .orElseThrow(() -> new Exception404("상영시간정보가 없습니다."));

        Long screenId = showtimePS.getScreen().getId();

        Screen screenPS = screenRepository.mFindAllById(screenId)
                .orElseThrow(() -> new Exception404("상영관정보가 없습니다."));

        return new SeatResponse.DTO(showtimePS, screenPS);
    }

    public SeatResponse.SeatDTO 좌석렌더링(long id) {

        List<Seat> seatPS = seatRepository.mFindAllByShowtimeId(id); // 좌석 영속

        List<Seat> reservedSeatPS = ticketRepsoitory.mFindSeatByShowtimeId(id); // 예약된 좌석 영속

        int maxCols = 0; // 최대 column 갯수
        int maxRows = 0; // 최대 Row 갯수

        // 먼저 최대 Column 갯수와 Row 갯수를 뽑아내자.
        for (Seat seat : seatPS) {
            Character colNum = seat.getColNum(); // '1', '2', '3', '4', '5', ...
            Character rowNum = seat.getRowNum(); // A, B

            int colIndex = Character.getNumericValue(colNum); // 5
            int rowIndex = rowNum - 'A' + 1; // 2

            // 최대 열과 행을 업데이트
            if (colIndex > maxCols) {
                maxCols = colIndex; // 5
            }

            if (rowIndex > maxRows) {
                maxRows = rowIndex; // 2
            }
        }

        // 계산된 최대 열과 행을 사용하여 배열 생성
        Seat[][] seatArray = new Seat[maxRows][maxCols]; // 2 5 -> 2차원 배열 seatArray 의 크기는 2행 5열이다.
        List<SeatResponse.SeatDTO.SeatInfo> seatInfos = new ArrayList<>(); // 각 좌석의 id를 담는 배열

        // 다시 좌석 정보를 배열에 넣는 작업
        for(Seat seat : seatPS){

            Character colNum = seat.getColNum(); // 1, 2, 3, 4, 5
            Character rowNum = seat.getRowNum(); // A, B
            Long seatId = seat.getId();

            int colIndex = Character.getNumericValue(colNum) - 1; // 배열 인덱스는 0부터 시작하므로 -1
            int rowIndex = rowNum - 'A'; // // 배열 인덱스는 0부터 시작하므로 'A'는 0, 'B'는 1

            seatArray[rowIndex][colIndex] = seat;

            seatInfos.add(new SeatResponse.SeatDTO.SeatInfo(seatId, rowNum, colNum));


        }

        return new SeatResponse.SeatDTO(seatInfos, seatArray, reservedSeatPS);
    }

    @Transactional
    public void 예매등록티켓생성(User sessionUser){

        // 예매 생성
        Reservation reservation = new Reservation();

        reservation.setUser(sessionUser);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        reservation.setCreatedAt(timestamp);

        Reservation reservationPS = reservationRepository.save(reservation);

        // 좌석 생성
        Long reservationPSId = reservationPS.getId();



    }

}
