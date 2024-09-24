package shop.mtcoding.filmtalk.poster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.movie.Movie;

import java.util.List;

public interface PosterRepository extends JpaRepository<Poster, Long> {

    @Query("SELECT p FROM Poster p WHERE p.movie = :movie")
    List<Poster> mFindAllByMovie(Movie movie);



    // movieId로 posterUrl 조회를 위해 쿼리 추가
    // PaymentService에서 posterRepository.findPosterUrlByMovieId(movie.getId()), -> 이 부분 에러
    @Query("select p.url from Poster p where p.movie.id = :movieId")
    List<String> findPosterUrlByMovieId(@Param("movieId") Long movieId);
}
