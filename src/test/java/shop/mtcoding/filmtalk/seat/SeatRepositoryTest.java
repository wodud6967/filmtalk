package shop.mtcoding.filmtalk.seat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class SeatRepositoryTest {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;
    @Autowired
    private ScreenRepository screenRepository;

    @Test
    public void 쇼타임ID로영화상영관영화관조회(){
        int id = 1;
        Optional<Showtime> showtime = showtimeRepository.mFindById(id);
        Timestamp startedAt = showtime.get().getStartedAt();
        LocalDate date = startedAt.toLocalDateTime().toLocalDate();
        LocalTime time = startedAt.toLocalDateTime().toLocalTime();

        if (showtime.isPresent()) {
            System.out.println(showtime.get().getMovie().getMovieNm()); // 인터스텔라
            System.out.println(showtime.get().getMovie().getRatingGrade()); // 12세
            System.out.println(showtime.get().getStartedAt().toString()); // 시간

            Long screenId = showtime.get().getScreen().getId();
            Optional<Screen> screen = screenRepository.mFindAllById(screenId);
            System.out.println(screen.get().getCinema().getName());
            System.out.println(screen.get().getCinema().getImgName());

            System.out.println(showtime.get().getScreen().getName()); // 레이지로딩. 서면 1상영관
            System.out.println(showtime.get().getScreen().getCinema().getName()); // 레이지로딩 . 서면 롯데시네마
            System.out.println(showtime.get().getScreen().getCinema().getRegion().getCity()); // 레이지 로딩. 부산
            System.out.println("Date: " + date);
            System.out.println("Time: " + time);



        } else {
            System.out.println("없어요");
        }
    }

    @Test
    public void mFindAllByShowtimeId_test(){
        //given
        Long showtimeId = 1L;
        // 열과 행의 최댓값 (초기화)
        int maxCols = 0;
        int maxRows = 0;

        //when
        List<Seat> seats = seatRepository.mFindAllByShowtimeId(showtimeId);

        System.out.println(seats.size()); // 9
        //List<String> seatNumbers = new ArrayList<>();

        // 좌석 정보에서 최대 열과 행을 찾아야 하므로 먼저 탐색
        for(Seat seat : seats){
            Character colNum = seat.getColNum();
            //System.out.println(colNum); // 2 3 4 5 1 2 3 4 5
            Character rowNum = seat.getRowNum(); // A B
            //System.out.println(rowNum);
            // colNum이 문자여서 숫자로 변환
            int colIndex = Character.getNumericValue(colNum);
            //System.out.println("colIndex: " + colIndex); // 2 3 4 5 1 2 3 4 5
            int rowIndex = rowNum - 'A' + 1; // A = 1, B = 2 // 1 1 1 2 2 2 2 2
            //System.out.println("rowIndex: " + rowIndex);

            // 최대 열과 행을 업데이트
            if(colIndex > maxCols){
                maxCols = colIndex;
            }

            if(rowIndex > maxRows){
                maxRows = rowIndex;
            }

            //String seatDetail = String.valueOf(rowNum) + colNum;
            //seatNumbers.add(seatDetail);
        }

        System.out.println(maxCols); // 5
        System.out.println(maxRows); // 2

        // 계산된 최대 열과 행을 사용하여 배열 생성
        Seat[][] seatArray = new Seat[maxRows][maxCols]; // seat[2][5]

        // 다시 좌석 정보를 배열에 넣는 작업
        for(Seat seat : seats){
            Character colNum = seat.getColNum(); // 1, 2, 3, 4, 5
            Character rowNum = seat.getRowNum(); // A, B


            int colIndex = Character.getNumericValue(colNum) - 1; // 배열 인덱스는 0부터 시작하므로 -1
            int rowIndex = rowNum - 'A'; // 배열 인덱스는 0부터 시작하므로 'A'는 0, 'B'는 1

            seatArray[rowIndex][colIndex] = seat;

            for(int i = 0; i < maxRows; i++){
                for(int j = 0; j < maxCols; j++){
                    if(seatArray[i][j] != null){
                        System.out.println(seatArray[i][j].getRowNum() + seatArray[i][j].getColNum());
                    }else{
                        System.out.println("X");

                    }

                }
                System.out.println();
            }



//            colIndex = Character.getNumericValue(colNum) - 1; // 0 based index로 바꿈
//            // row 문자를 'A'를 기준으로 아스키 코드 변환 ( A -> 0, B -> 1 )
//            System.out.println("colIndex " + colIndex); // 1 2
//            rowIndex = rowNum - 'A'; // A부터 0인덱스
//            System.out.println("rowIndex " + rowIndex); // 0 0
//            // 2D 배열에 좌석 배치
//            seatArray[rowIndex][colIndex] = seat;

        }


        //eye
        //System.out.println(seatNumbers);
        System.out.println("이차원배열 길이 : " + seatArray.length);

        // 좌석 배열 확인용 출력
        for (int i = 0; i < seatArray.length; i++) {
            for (int j = 0; j < seatArray[i].length; j++) {
                Seat seat = seatArray[i][j];
                if (seat != null) {
                    System.out.print("[" + seat.getRowNum() + seat.getColNum() + "] ");
                } else {
                    System.out.print("[ ] "); // 중간에 빈 좌석
                }
            }
            System.out.println(); // 행이 끝나면 줄 바꿈
        }

        // 확인용 출력
        System.out.println("Max Columns: " + maxCols);
        System.out.println("Max Rows: " + maxRows);

    }


}
