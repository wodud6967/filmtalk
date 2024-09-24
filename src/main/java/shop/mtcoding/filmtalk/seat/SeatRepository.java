package shop.mtcoding.filmtalk.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {


    @Query("select s from Seat s join fetch s.showtime st where st.id = :showtimeId")
    List<Seat> mFindAllByShowtimeId(@Param("showtimeId") Long showtimeId);

    // 전체 좌석 수
    @Query("SELECT count(s.colNum) as total_seat_count FROM Seat s where s.showtime.id = :showtimeId")
    Integer mFindCountOfTotalSeat(@Param("showtimeId") Long showtimeId);

    // 서브쿼리 사용. 남은 좌석 수
/*    SELECT
    (SELECT count(col_num) as total_seat_num FROM SEAT_TB where showtime_id = 3)
            -
            (SELECT count(seat_id) as selected_seat_num from ticket_tb where showtime_id = 3)
    AS available_seat_num;*/
}
