package shop.mtcoding.filmtalk.showtime;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ShowtimeQueryRepository {
    private final EntityManager em;
}
