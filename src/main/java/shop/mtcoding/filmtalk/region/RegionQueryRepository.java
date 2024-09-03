package shop.mtcoding.filmtalk.region;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RegionQueryRepository {
    private final EntityManager em;
}
