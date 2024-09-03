package shop.mtcoding.filmtalk.cinema;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CinemaQueryRepository {
    private final EntityManager em;
}
