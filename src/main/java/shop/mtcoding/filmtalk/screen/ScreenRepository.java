package shop.mtcoding.filmtalk.screen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.filmtalk.showtime.Showtime;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    //Admin이 테스트중 5일의 상영관의 상영시간을 가져오기

    // 특정 영화관의 상영관 리스트 조회
    @Query("SELECT s FROM Screen s WHERE s.cinema.id = :cinemaId")
    List<Screen> mFindByCinemaId(@Param("cinemaId") Long cinemaId);
    //TODO : 파라미터가 2개 들어올 때 AND
    // 오버로딩
    @Query("SELECT s FROM Screen s WHERE s.cinema.id = :cinemaId")
    List<Screen> mFindByCinemaIdAndName(@Param("cinemaId") Long cinemaId,String name);

    @Query("select s from Screen s where s.cinema.id in :cinemaIds")
    List<Screen> mFindByCinemaIds(@Param("cinemaIds") List<Long> cinemaIds);

}
