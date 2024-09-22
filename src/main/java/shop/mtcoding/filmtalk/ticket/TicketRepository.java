package shop.mtcoding.filmtalk.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select t.seat.seatNumber from Ticket t where t.reservation.id = :reservationId")
    List<String> findSeatNumbersByReservationId(@Param("reservationId") Long reservationId);

    // 중복 데이터 처리
    @Query("select distinct t from Ticket t left join fetch t.seat s where t.reservation.id = :reservationId")
    List<Ticket> findByReservationId(@Param("reservationId") Long reservationId);

}
