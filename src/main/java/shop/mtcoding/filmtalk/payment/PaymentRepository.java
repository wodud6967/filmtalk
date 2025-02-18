package shop.mtcoding.filmtalk.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByReservationId(Long reservationId);
}
