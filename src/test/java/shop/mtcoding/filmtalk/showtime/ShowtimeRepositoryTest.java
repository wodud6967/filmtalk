package shop.mtcoding.filmtalk.showtime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.cinema.CinemaRepository;

import shop.mtcoding.filmtalk.region.Region;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.user.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ShowtimeRepositoryTest {

    @Autowired
    private ShowtimeRepository showtimeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    @Test
    public void mFindAll_test() {
        List<Showtime> showtimes = showtimeRepository.mFindAll();
        for (Showtime showtime : showtimes) {
            System.out.println("Started At: " + showtime.getStartedAt());
            // 다른 엔티티의 정보도 출력 가능
            System.out.println("Screen Name: " + showtime.getScreen().getName());
            System.out.println("Cinema Name: " + showtime.getScreen().getCinema().getName());
            System.out.println("Region City: " + showtime.getScreen().getCinema().getRegion().getCity());
            System.out.println("Movie Name: " + showtime.getMovie().getMovieNm());
            System.out.println("Rating Grade: " + showtime.getMovie().getRatingGrade());

        }
    }

    @Test
    public void mFindById_test() {
        int id = 1;
        Optional<Showtime> showtime = showtimeRepository.mFindById(id);
        Timestamp startedAt = showtime.get().getStartedAt();
        LocalDate date = startedAt.toLocalDateTime().toLocalDate();
        LocalTime time = startedAt.toLocalDateTime().toLocalTime();

        if (showtime.isPresent()) {
            System.out.println(showtime.get().getMovie().getMovieNm());
            System.out.println(showtime.get().getMovie().getRatingGrade());
            System.out.println(showtime.get().getStartedAt().toString());
            System.out.println(showtime.get().getScreen().getName());
            System.out.println(showtime.get().getScreen().getCinema().getName());
            System.out.println(showtime.get().getScreen().getCinema().getRegion().getCity());
            System.out.println("Date: " + date);
            System.out.println("Time: " + time);
        } else {
            System.out.println("없어요");
        }
    }

    @Test
    public void mFindCinemaById_test() {
        Long id = 1L;
        Cinema cinema = cinemaRepository.mFindCinemaById(id);

        System.out.println("영화관 정보:");
        System.out.println("Cinema ID: " + cinema.getId());
        System.out.println("Cinema Name: " + cinema.getName());


        System.out.println(cinema.getScreens().size());

        List<Screen> screens = cinema.getScreens();

        List<Long> screenIds = screens.stream().map(screen -> screen.getId()).toList();
        // 상영관들
        System.out.println("상영관 목록:");
        for (Screen screen : screens) {
            System.out.println("  Screen ID: " + screen.getId());
            System.out.println("  Screen Name: " + screen.getName());
            System.out.println("  ------------");
            List<Showtime> showtimes = screen.getShowtimes();
            System.out.println("상영시간숫자 : " + showtimes.size());
            System.out.println("  상영시간 목록:");
            // 상영시간들
            /**
             *     select
             *         s1_0.screen_id,
             *         s1_0.id,
             *         s1_0.movie_id,
             *         s1_0.started_at
             *     from
             *         showtime_tb s1_0
             *     where
             *         s1_0.screen_id=?
             */

            for (Showtime showtime : showtimes) {
                // select * from showtime_tb where screen_id in (ids)
                // repository.조회(screenIds);
                System.out.println("    Showtime ID: " + showtime.getId());
                System.out.println("    상영 시작 시간: " + showtime.getStartedAt());
            }
        }
    }

    @Test
    public void mFindCinemaRegionById_test() {
        Long id = 1L;

        Cinema cinema = cinemaRepository.mFindCinemaRegionById(id);

        System.out.println("영화관 정보:");
        System.out.println("Cinema ID: " + cinema.getId());
        System.out.println("Cinema Name: " + cinema.getName());




        System.out.println("regions "+cinema.getRegion().getCity());

    }
}
