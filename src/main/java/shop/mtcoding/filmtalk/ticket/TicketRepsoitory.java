package shop.mtcoding.filmtalk.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.seat.Seat;

import java.util.List;

public interface TicketRepsoitory extends JpaRepository<Ticket, Long> {

    @Query("select t.seat from Ticket t where t.showtime.id = :showtimeId")
    List<Seat> mFindSeatByShowtimeId(@Param("showtimeId") Long showtimeId);
}
