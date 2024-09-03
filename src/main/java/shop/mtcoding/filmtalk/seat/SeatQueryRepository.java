package shop.mtcoding.filmtalk.seat;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SeatQueryRepository {
    private final EntityManager em;
}
