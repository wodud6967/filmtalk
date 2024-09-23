package shop.mtcoding.filmtalk.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m left join fetch m.posterUrls p order by m.id desc")
    List<Movie> mFindAllWithPosterUrls();

    @Query("select m from Movie m left join fetch m.comments c left join fetch c.user u " +
            " where m.id =:id order by c.createdAt DESC")
    Optional<Movie> mFindOneWithCommentsById(int id);

    @Query("SELECT m FROM Movie m " +
        "WHERE (:movieNm IS NULL OR m.movieNm LIKE %:movieNm%) " +
        "AND (:director IS NULL OR m.director LIKE %:director%) " +
        "AND (:nationNm IS NULL OR m.nationNm LIKE %:nationNm%) " +
        "AND (:company IS NULL OR m.company LIKE %:company%) " +
        "AND (:ratingGrade IS NULL OR m.ratingGrade LIKE %:ratingGrade%)")
    List<Movie> mFindAll(@Param("movieNm") String movieNm,
                     @Param("director") String director,
                     @Param("nationNm") String nationNm,
                     @Param("company") String company,
                     @Param("ratingGrade") String ratingGrade);
}
