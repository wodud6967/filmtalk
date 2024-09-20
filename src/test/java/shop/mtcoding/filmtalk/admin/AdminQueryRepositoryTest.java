package shop.mtcoding.filmtalk.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.cinema.CinemaQueryRepository;
import shop.mtcoding.filmtalk.cinema.CinemaRepository;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenQueryRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@Import({ScreenQueryRepository.class, CinemaQueryRepository.class}) // CinemaRepository 추가
public class AdminQueryRepositoryTest {

    @Autowired
    private ScreenQueryRepository screenQueryRepository;

    @Autowired
    private  CinemaRepository cinemaRepository;

    @Autowired
    private  CinemaQueryRepository cinemaQueryRepository;


}
