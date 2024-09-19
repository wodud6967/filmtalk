package shop.mtcoding.filmtalk.seat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.ticket.TicketRepsoitory;
import shop.mtcoding.filmtalk.user.User;

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

    public SeatResponse.DTO 좌석메인화면(long id) {

        Showtime showtimePS = showtimeRepository.mFindById(id)
                .orElseThrow(() -> new Exception404("상영시간정보가 없습니다."));

        Long screenId = showtimePS.getScreen().getId();

        Screen screenPS = screenRepository.mFindAllById(screenId)
                .orElseThrow(() -> new Exception404("상영관정보가 없습니다."));

        return new SeatResponse.DTO(showtimePS, screenPS);
    }

    public SeatResponse.SeatDTO 좌석렌더링(long id) {

        List<Seat> seatPS = seatRepository.mFindAllByShowtimeId(id);

        List<Seat> reservedSeatPS = ticketRepsoitory.mFindSeatByShowtimeId(id);

        int maxCols = 0;
        int maxRows = 0;

        for (Seat seat : seatPS) {
            Character colNum = seat.getColNum(); // '1', '2', '3', '4', '5', ...
            Character rowNum = seat.getRowNum();

            int colIndex = Character.getNumericValue(colNum);
            int rowIndex = rowNum - 'A' + 1;

            // 최대 열과 행을 업데이트
            if (colIndex > maxCols) {
                maxCols = colIndex;
            }

            if (rowIndex > maxRows) {
                maxRows = rowIndex;
            }
        }

        // 계산된 최대 열과 행을 사용하여 배열 생성
        Seat[][] seatArray = new Seat[maxRows][maxCols];

        // 다시 좌석 정보를 배열에 넣는 작업
        for(Seat seat : seatPS){
            Character colNum = seat.getColNum(); // 1, 2, 3, 4, 5
            Character rowNum = seat.getRowNum();

            int colIndex = Character.getNumericValue(colNum) - 1; // 배열 인덱스는 0부터 시작하므로 -1
            int rowIndex = rowNum - 'A'; // // 배열 인덱스는 0부터 시작하므로 'A'는 0, 'B'는 1

            seatArray[rowIndex][colIndex] = seat;

        }

        return new SeatResponse.SeatDTO(seatArray, reservedSeatPS);
    }

}
