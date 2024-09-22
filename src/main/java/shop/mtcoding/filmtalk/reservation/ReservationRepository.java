package shop.mtcoding.filmtalk.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.payment.PaymentResponse;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // reservationId로 조회 시 중복된 티켓을 제거하고 각각의 예약 정보 가져옴
    @Query("select distinct r from Reservation r join fetch r.tickets t join fetch t.showtime s join fetch s.movie m where r.id = :reservationId")
    Optional<Reservation> findById(@Param("reservationId") Long reservationId);

}
