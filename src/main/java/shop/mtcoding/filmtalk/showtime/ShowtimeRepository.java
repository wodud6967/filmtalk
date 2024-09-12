package shop.mtcoding.filmtalk.showtime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

    // 특정 상영관들의 ID 리스트로 상영시간 조회
    @Query("SELECT s FROM Showtime s WHERE s.screen.id IN :screenIds")
    List<Showtime> findByScreenIds(@Param("screenIds") List<Long> screenIds);
}
