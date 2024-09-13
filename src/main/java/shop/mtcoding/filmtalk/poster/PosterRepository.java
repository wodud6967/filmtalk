package shop.mtcoding.filmtalk.poster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.mtcoding.filmtalk.movie.Movie;

import java.util.List;

public interface PosterRepository extends JpaRepository<Poster, Long> {

    @Query("SELECT p FROM Poster p WHERE p.movie = :movie")
    List<Poster> mFindAllByMovie(Movie movie);
}
