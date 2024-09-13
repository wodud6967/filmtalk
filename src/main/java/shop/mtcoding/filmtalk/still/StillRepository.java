package shop.mtcoding.filmtalk.still;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.mtcoding.filmtalk.movie.Movie;

import java.util.List;

public interface StillRepository extends JpaRepository<Still, Long> {


    @Query("SELECT s FROM Still s WHERE s.movie = :movie")
    List<Still> mFindAllByMovie(Movie movie);
}
