package shop.mtcoding.filmtalk.showtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.filmtalk.user.UserQueryRepository;

@DataJpaTest
@Import(ShowtimeQueryRepository.class)
public class ShowtimeQueryRepositoryTest {

    @Autowired
    public ShowtimeQueryRepository showtimeQueryRepository;


}
