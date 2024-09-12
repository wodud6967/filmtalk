package shop.mtcoding.filmtalk.showtime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.List;



public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

    // 특정 상영관들의 ID 리스트로 상영시간 조회
    @Query("SELECT s FROM Showtime s WHERE s.screen.id IN :screenIds")
    List<Showtime> mFindByScreenIds(@Param("screenIds") List<Long> screenIds);

    @Query("select st from Showtime st join fetch st.movie m left join fetch st.screen sc where st.id=:id")
    Showtime mFindByIdWithMovieWithScreen(@Param("id") Long id);
    //뭐 다 담은 것
    @Query("select st.startedAt, stb.name, ct.name, rt.city, mt.movieNm, mt.ratingGrade from Showtime st left join st.screen stb left join stb.cinema ct left join ct.region rt left join st.movie mt")
    List<Showtime> mFindAll();

    @Query("select st from Showtime st left join fetch st.movie mt where st.id=:id")
    Optional<Showtime> mFindById(@Param("id") int id);

}
