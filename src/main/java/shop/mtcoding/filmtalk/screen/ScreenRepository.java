package shop.mtcoding.filmtalk.screen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.filmtalk.showtime.Showtime;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    //Admin이 테스트중 5일의 상영관의 상영시간을 가져오기


    @Query("select s from Screen s where s.cinema.id in :cinemaIds")
    List<Screen> mFindScreenByCinemaIds(@Param("cinemaIds") List<Long> cinemaIds);

    List<Screen> mfindByCinemaId(@Param("cinemaId") Long cinemaId);




}
