package shop.mtcoding.filmtalk.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(UserQueryRepository.class)
public class UserRepositoryTest {

    @Autowired
    public UserQueryRepository userRepository;

    @Test
    public void findByUsername_test() {
        String username = "haha";
        User user = userRepository.findByUsername(username);

        System.out.println("user = " + user);
    }

    @Test
    public void findByUsernameAndPassword_test() {

        //given
        String username = "ssar";
        String passwrod = "1234";

        User user = userRepository.findByUsernameAndPassword(username, passwrod);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    @Test
    public void save_test() {
        String username = "haha";
        String password = "1234";
        String email = "haha@nate.com";

        User user = User.builder().username(username).password(password).email(email).build();

        userRepository.save(user);
    }
}
