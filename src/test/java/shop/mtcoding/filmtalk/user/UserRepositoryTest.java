package shop.mtcoding.filmtalk.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;

import javax.swing.plaf.PanelUI;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;





    //TODO 로그인 테스트
    @Test
    public void findByUsernameAndPassword_test() {
        //존재하는 유저
        String username = "ssar";
        String passwrod = "1234";
        Optional<User> userOP = userRepository.mFindByUsernameAndPassword(username, passwrod);
        if(userOP.isPresent()){
            System.out.println("테스트성공");
            System.out.println(userOP.get().getUsername());
        }

    }
    //TODO 회원가입 테스트
    @Test
    public void save_test(){
        //없는 유저
        User user = User.builder()
                .username("wodud6967")
                .password("1234")
                .email("wodud6967@gmail,com")
                .phone("010-4808-6967")
                .build();

        User newUser = userRepository.save(user);

        if (newUser != null) {
            System.out.println("테스트성공");
            System.out.println(newUser);
            System.out.println(newUser.getUsername());

        }else {
            System.out.println("테스트실패");
        }



    }




    //TODO 유저이름 중복체크 테스트
    @Test
    public void findByUsername_test(){
        //존재하는 유저
        String username = "ssar";


        //있는 유저네임등록
        User user = User.builder()
                .username(username)
                .build();
        Optional<User> existingUser = userRepository.mFindByUsername(user.getUsername());

        assertFalse(existingUser.isEmpty(),"테스트실패-디비에 없는 유저입니다.");
        if (existingUser.isPresent()){
            System.out.println("테스트성공");
            System.out.println( existingUser .get().getUsername());
        }

        //없는 유저네임등록
        User user2 = User.builder()
                .username("wodud6967")
                .build();
        Optional<User> nonExistingUser= userRepository.mFindByUsername(user2.getUsername());
        assertFalse(nonExistingUser.isPresent(),"테스트실패");
        if (nonExistingUser.isEmpty()){
            System.out.println("테스트성공");
        }

    }


}
