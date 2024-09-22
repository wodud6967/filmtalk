package shop.mtcoding.filmtalk.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // 하나의 reservationId로 여러 티켓을 반환
    @Query("select t from Ticket t where t.reservation.id = :reservationId")
    List<Ticket> findByReservationId(@Param("reservationId") Long reservationId);

    // 중복 데이터 처리
    @Query("select distinct r from Reservation r left join fetch r.tickets t where r.id = :reservationId")
    Optional<Reservation> findById(@Param("reservationId") Long reservationId);


}
