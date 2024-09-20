package shop.mtcoding.filmtalk.screen;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.filmtalk.showtime.Showtime;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, Long> {


    //TODO MYSQL로 바꾸면 바꿔야함
    /*
    * MySQL은 DATE() 함수를 지원하지만, H2나 다른 데이터베이스에서는 이를 지원하지 않을 수 있습니다.
      대안으로 CAST나 TRUNC 함수를 사용하여 시간 부분을 제거하고 날짜만 비교할 수 있습니다.
    *  여기서는 H2 데이터베이스에서 사용할 수 있는 CAST를 이용한 방법*/
    @Query("SELECT DISTINCT s FROM Screen s " +
            "LEFT JOIN FETCH s.showtimes st " +  // LEFT JOIN으로 showtimes와 연결
            "LEFT JOIN FETCH st.movie " +  // 영화 정보도 가져옴
            "WHERE s.id IN :screenIds " +  // 상영관 목록을 가져옴
            "AND (st IS NULL OR CAST(st.startedAt AS DATE) = :selectedDate)")  // 상영 시간이 없거나, 해당 날짜에 맞는 상영 시간을 필터링
    List<Screen> findScreensWithShowtimesByIdsAndDate(@Param("screenIds") List<Long> screenIds,
                                                      @Param("selectedDate") LocalDate selectedDate);

    @Query(value = "SELECT s.*, st.* " +
            "FROM screen_tb s " +
            "LEFT JOIN showtime_tb st " +
            "ON s.id = st.screen_id " +
            "AND FORMATDATETIME(st.started_at, 'yyyy-MM-dd') = :selectedDate " +
            "WHERE s.id IN (:screenIds)",
            nativeQuery = true)
    List<Object[]> findScreensWithShowtimesByIdsAndDate2(@Param("screenIds") List<Long> screenIds,
                                                        @Param("selectedDate") String selectedDate);


    //Admin이 테스트중 5일의 상영관의 상영시간을 가져오기 in :cinemaIds
    @Query("SELECT s FROM Screen s LEFT JOIN FETCH s.showtimes st LEFT JOIN FETCH st.movie WHERE s.id IN :screenIds")
    List<Screen> findScreensWithShowtimesByIds(@Param("screenIds") List<Long> screenIds);

    @Query("select s from Screen s where s.cinema.id in :cinemaIds")
    List<Screen> mFindScreenByCinemaIds(@Param("cinemaIds") List<Long> cinemaIds);
    @Query("select s from Screen s where s.cinema.id in :cinemaId")
    List<Screen> mFindByCinemaId(@Param("cinemaId") Long cinemaId);
    @Query("select s from Screen s Join Fetch s.cinema c where s.id = :id and c.id = :cinemaId")
    Optional<Screen> mFindOneByIdAndCinemaId(@Param("id") Long id, @Param("cinemaId") Long cinemaId);
    @Query("select s from Screen s where s.id = :id")
    Optional<Screen> mFindAllById(@Param("id") Long id);
    //TODO 주헌
    @Query("select Distinct c from  Cinema c  join fetch c.screens s where c.id=:id")
    Optional<Screen> mFindByIdWithScreens(@Param("id") Long id);
    @Query("select s from Screen s where s.cinema.id in :cinemaIds")
    List<Screen> mFindScreenByCinemaId(@Param("cinemaIds") Long cinemaIds);
}

