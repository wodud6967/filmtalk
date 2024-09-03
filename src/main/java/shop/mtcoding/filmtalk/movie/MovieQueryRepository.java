package shop.mtcoding.filmtalk.movie;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MovieQueryRepository {

    private final EntityManager em;
    // 복잡한 쿼리 메서드 만드는 클래스
}
