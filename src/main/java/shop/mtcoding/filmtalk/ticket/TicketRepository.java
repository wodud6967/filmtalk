package shop.mtcoding.filmtalk.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.seat.Seat;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select t.seat from Ticket t where t.showtime.id = :showtimeId")
    List<Seat> mFindSeatByShowtimeId(@Param("showtimeId") Long showtimeId);

    // reservationId 로 티켓 리스트 조회
    @Query("select t from Ticket t join fetch t.seat s where t.reservation.id = :reservationId")
    List<Ticket> findByReservationId(@Param("reservationId") Long reservationId);

    // 예매된 좌석 수
    @Query("Select count(t.seat.id) as reserved_seat_count from Ticket t where t.showtime.id = :showtimeId")
    Integer mFindCountOfReservedSeats(@Param("showtimeId") Long showtimeId);
}
