package shop.mtcoding.filmtalk.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.still.Still;

import java.util.List;
import java.util.Set;


@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void findAll_test() {
        List<Movie> movies = movieRepository.mFindAllWithPosterUrls();

//        Assertions.assertTrue(movies.size() == 4);
        Assertions.assertTrue(movies.get(0).getPosterUrls().size() == 2);

    }
    @Test
    public void mFindByIdWithAll_test(){
        int id = 1;
        Movie movie = movieRepository.mFindByIdWithAll(id).orElseThrow(()->new Exception404("없는영화다"));
        System.out.println("----------------------------");
//        Set<Still> stillUrls = movie.getStillUrls();
//        for (Still still : stillUrls) {
//            System.out.println(still.getUrl());
//        }
//        Set<Poster> posterUrls = movie.getPosterUrls();
//        for (Poster poster : posterUrls) {
//            System.out.println(poster.getUrl());
//        }
    }
}
