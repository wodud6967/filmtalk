package shop.mtcoding.filmtalk.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m left join fetch m.posterUrls p order by m.id desc")
    List<Movie> mFindAllWithPosterUrls();

//    @Query("select m from Movie m left join fetch m.posterUrls p left join fetch m.stillUrls s " +
//            "left join fetch m.comments c where m.id =:id")
    @Query("select m from Movie m left join fetch m.comments c left join fetch c.user u " +
            " where m.id =:id")
    Optional<Movie> mFindOneWithCommentsById(int id);

}
