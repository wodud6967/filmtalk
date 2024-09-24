package shop.mtcoding.filmtalk.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // reservationId 로 티켓 리스트 조회
    @Query("select t from Ticket t join fetch t.seat s where t.reservation.id = :reservationId")
    List<Ticket> findByReservationId(@Param("reservationId") Long reservationId);

//    @Query("select distinct t from Ticket t join fetch t.seat s where t.reservation.id = :reservationId")
//    List<Ticket> findByReservationId(@Param("reservationId") Long reservationId);

}
