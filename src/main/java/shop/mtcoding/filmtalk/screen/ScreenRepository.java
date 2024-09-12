package shop.mtcoding.filmtalk.screen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    //Admin이 테스트중 5일의 상영관의 상영시간을 가져오기

    // 특정 영화관의 상영관 리스트 조회
    @Query("SELECT s FROM Screen s WHERE s.cinema.id = :cinemaId")
    List<Screen> mfindById(@Param("cinemaId") Long cinemaId);

    @Query("SELECT s FROM Screen s WHERE s.cinema.id = :cinemaId")
    List<Screen> mfindById(@Param("cinemaId") Long cinemaId,String name);

}
