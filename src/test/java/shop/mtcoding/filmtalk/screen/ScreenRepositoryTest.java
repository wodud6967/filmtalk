package shop.mtcoding.filmtalk.screen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ScreenRepositoryTest {

    @Autowired
    private ScreenRepository screenRepository;

    @Test
    public void mFindOneByIdAndCinemaId_tb(){

        Long id = 1L;
        Long cinemaId = 1L;

        Optional<Screen> screenOptional = screenRepository.mFindOneByIdAndCinemaId(id, cinemaId);

        // Optional이 비어 있지 않은지 체크
        if (screenOptional.isPresent()) {
            Screen screen = screenOptional.get();
            // Screen 객체 안의 필드 값을 출력
            System.out.println("Screen ID: " + screen.getId());
            System.out.println("Screen Name: " + screen.getName());
            System.out.println("Cinema ID: " + screen.getCinema().getId());
            System.out.println("Cinema Name: " + screen.getCinema().getName());
        } else {
            // Optional이 비어 있을 경우 예외 처리
            System.out.println("그런 상영관은 없습니다.");
        }
    }

    @Test
    public void mFindAllById(){
        Long id = 1L;

        Optional<Screen> screen = screenRepository.mFindAllById(id);

        if (screen.isPresent()) {
            System.out.println("Screen ID: " + screen.get().getId());
            System.out.println("Screen Name: " + screen.get().getName());
            System.out.println("Cinema ID: " + screen.get().getCinema().getId());
            System.out.println("Cinema Name: " + screen.get().getCinema().getName());
        }


    }

}
