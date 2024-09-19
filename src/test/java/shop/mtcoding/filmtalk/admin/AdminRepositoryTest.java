package shop.mtcoding.filmtalk.admin;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import retrofit2.http.PUT;
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

    @Test
    public void admin_mFindAllwithScreenByIds(){
        Long cinemaId = 1L;
        Cinema cinemas = cinemaRepository.mFindByIdWithScreen(cinemaId);
        List<Long> screenIds = new ArrayList<>();;
        for (Screen screen : cinemas.getScreens()) {
            screenIds.add(screen.getId());

        }
        for (Long screenId : screenIds) {
            System.out.println("상영관id = " + screenId);
        }

        // 저장된 상영관 ID들을 통해 상영관과 그에 속한 showtime을 조회
        List<Screen> screensWithShowtimes = screenRepository.findScreensWithShowtimesByIds(screenIds);

        // 결과 출력 (테스트용)
        for (Screen screen : screensWithShowtimes) {
            System.out.println("상영관 id = " + screen.getId());
            for (Showtime showtime : screen.getShowtimes()) {
                System.out.println("상영시간 = " + showtime.getMovie().getRuntime());
            }
        }
    }

    @Test
    public  void mFindAllWithScreen(){
     List<Cinema> cinemas = cinemaRepository.mFindAllWithScreen();
     for (Cinema cinema : cinemas) {
         System.out.println(cinema.getName());
            List<Screen> screens =  cinema.getScreens();
                 for (Screen screen : screens) {

                     System.out.println(screen.getName());

                 }
     }

    }

    @Test
    public void mFindByOneUsernameAndPassword_test(){
       Admin admin = adminRepository.mFindByOneUsernameAndPassword("ssar","1234").get();
        System.out.println(admin.getUsername());
        System.out.println(admin.getName());
    }

}
