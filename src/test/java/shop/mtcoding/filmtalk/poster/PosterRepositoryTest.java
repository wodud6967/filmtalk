package shop.mtcoding.filmtalk.poster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PosterRepositoryTest {
    @Autowired
    private PosterRepository repository;

    @Test
    public void findPosterUrlByMovieId_test(){
        repository.findPosterUrlByMovieId(1L);
    }
}
