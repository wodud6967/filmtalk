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

}
