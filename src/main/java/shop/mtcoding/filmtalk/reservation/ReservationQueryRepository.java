package shop.mtcoding.filmtalk.reservation;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReservationQueryRepository {
    private final EntityManager em;
}
