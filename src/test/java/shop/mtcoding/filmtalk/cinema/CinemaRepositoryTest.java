package shop.mtcoding.filmtalk.cinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.user.UserRepository;

@DataJpaTest
public class CinemaRepositoryTest {
    @Autowired
    private CinemaRepository userRepository;

    @Test
    public void findByUsernameAndPassword_test(){
        String username = "ssar";
        String password = "1234";


    }

}
