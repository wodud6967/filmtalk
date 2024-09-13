package shop.mtcoding.filmtalk.cinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.user.UserRepository;

import java.util.List;

@DataJpaTest
public class CinemaRepositoryTest {
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;


    @Test
    public void mFindById_test() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        System.out.println("==========================");
        List<Long> cinemaIds = cinemas.stream().map(cinema -> cinema.getId()).toList();

        List<Screen> screens = screenRepository.mFindScreenByCinemaIds(cinemaIds);
        System.out.println("==========================");
        List<Long> screenIds = screens.stream().map(screen -> screen.getId()).toList();

        List<Showtime> showtimes = showtimeRepository.mFindByScreenIds(screenIds);
        System.out.println("==========================");
        for (Screen screen : screens) {
            System.out.println("  Screen ID: " + screen.getId());
            System.out.println("  Screen Name: " + screen.getName());
            System.out.println("  ------------");
            for (Showtime showtime : showtimes) {
                System.out.println("    Showtime ID: " + showtime.getId());
                System.out.println("    상영 시작 시간: " + showtime.getStartedAt());
            }
        }

    }
}


