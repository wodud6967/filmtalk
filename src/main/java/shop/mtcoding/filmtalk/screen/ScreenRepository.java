package shop.mtcoding.filmtalk.screen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.filmtalk.showtime.Showtime;

import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    //Admin이 테스트중 5일의 상영관의 상영시간을 가져오기

    @Query("select s from Screen s where s.cinema.id in :cinemaIds")
    List<Screen> mFindScreenByCinemaIds(@Param("cinemaIds") List<Long> cinemaIds);
    @Query("select s from Screen s where s.cinema.id in :cinemaId")
    List<Screen> mFindByCinemaId(@Param("cinemaId") Long cinemaId);
    @Query("select s from Screen s Join Fetch s.cinema c where s.id = :id and c.id = :cinemaId")
    Optional<Screen> mFindOneByIdAndCinemaId(@Param("id") Long id, @Param("cinemaId") Long cinemaId);
    @Query("select s from Screen s where s.id = :id")
    Optional<Screen> mFindAllById(@Param("id") Long id);

 }
