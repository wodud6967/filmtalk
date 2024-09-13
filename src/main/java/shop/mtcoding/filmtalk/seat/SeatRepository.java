package shop.mtcoding.filmtalk.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("select s from Seat s join fetch s.showtime st where s.showtime=:showtimeId")
    Optional<List<Seat>> findByShowtimeid(@Param("showtimeId") Long showtimeId);

    
}
