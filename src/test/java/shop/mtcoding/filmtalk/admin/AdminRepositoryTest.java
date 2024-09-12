package shop.mtcoding.filmtalk.admin;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.cinema.CinemaRepository;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.user.User;
import shop.mtcoding.filmtalk.user.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;

    /*상영시간 등록하기 */

    @Test
    public void shotime_mFindScreenShowtime_test(){
        //상영관을 가져와서 Lazy하는 방식
        Long cinameId = 1L;
        Cinema cinema =  cinemaRepository.mFindCinemaById(cinameId);

        System.out.println(cinema.getScreens().size());
        List<Screen> screens = cinema.getScreens();

        List<Long> screenIds = screens.stream().map(screen -> screen.getId()).toList();

        System.out.println("상영관 목록:");
        for (Screen screen : screens) {
            System.out.println("  Screen ID: " + screen.getId());
            System.out.println("  Screen Name: " + screen.getName());
            System.out.println("  ------------");

            List<Showtime> showtimes = screen.getShowtimes();

/*------------------------------------------------------------------------*/
/*여기까지는 lazy가 get을 안함*/
            for (Showtime showtime : showtimes) {
                // select * from showtime_tb where screen_id in (ids)
                // repository.조회(screenIds);
                System.out.println("    Showtime ID: " + showtime.getId()); //여기서 select쿼리가 나감
                System.out.println("    상영 시작 시간: " + showtime.getStartedAt());
            }

        }
    }


    @Test
    public void shotime_mFindScreenShowtime_test2(){
        //상영관을 가져와서 Lazy하는 방식
        Long cinameId = 1L;
        Cinema cinema =  cinemaRepository.mFindCinemaById(cinameId);

        System.out.println(cinema.getScreens().size());
        List<Screen> screens = cinema.getScreens();

        List<Long> screenIds = screens.stream().map(screen -> screen.getId()).toList();

        System.out.println("상영관 목록:");
        for (Screen screen : screens) {
            System.out.println("  Screen ID: " + screen.getId());
            System.out.println("  Screen Name: " + screen.getName());
            System.out.println("  ------------");

            List<Showtime> showtimes = screen.getShowtimes();

            /*------------------------------------------------------------------------*/
            /*여기까지는 lazy가 get을 안함*/
            for (Showtime showtime : showtimes) {
                // select * from showtime_tb where screen_id in (ids)
                // repository.조회(screenIds);
                System.out.println("    Showtime ID: " + showtime.getId()); //여기서 select쿼리가 나감
                System.out.println("    상영 시작 시간: " + showtime.getStartedAt());
            }

        }
    }


    @Test
    public void reset_day(){
        // 오늘 날짜 가져오기
        LocalDate today = LocalDate.now();

        // 날짜 포맷 설정 (12일, 화요일 형식)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d일, E요일");

        // 10일 동안의 날짜와 요일 리스트 생성
        List<String> showtimeDates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LocalDate showtimeDate = today.plusDays(i); // i일 추가
            String formattedDate = showtimeDate.format(dateFormatter);
            showtimeDates.add(formattedDate);
        }

        // 결과 출력
        for (String date : showtimeDates) {
            System.out.println(date);
        }
    }





}
