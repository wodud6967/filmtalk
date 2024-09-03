package shop.mtcoding.filmtalk.admin;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AdminQueryRepository {
    private final EntityManager entityManager;
}
