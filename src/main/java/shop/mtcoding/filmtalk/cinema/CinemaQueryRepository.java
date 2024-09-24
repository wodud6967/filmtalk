package shop.mtcoding.filmtalk.cinema;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CinemaQueryRepository {
    private final EntityManager em;
    // 특정 Cinema의 모든 Screen을 네이티브 쿼리로 가져오기
    public Cinema mFindByIdWithScreen(Long id) {
        String sql = "SELECT DISTINCT c.* FROM cinema_tb c " +
                "JOIN screen_tb s ON c.id = s.cinema_id " +
                "WHERE c.id = :id";
        Query nativeQuery = em.createNativeQuery(sql, Cinema.class);
        nativeQuery.setParameter("id", id);
        return (Cinema) nativeQuery.getSingleResult();
    }

}
