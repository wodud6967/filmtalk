package shop.mtcoding.filmtalk.screen;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ScreenQueryRepository {
    private final EntityManager em;
}
