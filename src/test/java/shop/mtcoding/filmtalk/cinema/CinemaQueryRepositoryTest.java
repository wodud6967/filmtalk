package shop.mtcoding.filmtalk.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.filmtalk.user.UserQueryRepository;

@DataJpaTest
@Import(CinemaQueryRepository.class)
public class CinemaQueryRepositoryTest {
    @Autowired
    private CinemaQueryRepository cinemaQueryRepository;
}
