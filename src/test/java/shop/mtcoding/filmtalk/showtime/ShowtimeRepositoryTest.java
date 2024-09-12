package shop.mtcoding.filmtalk.showtime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.user.UserRepository;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ShowtimeRepositoryTest {
    @Autowired
    private ShowtimeRepository ShowtimeRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Test
    public void mFindAll_test() {
        List<Showtime> showtimes = showtimeRepository.mFindAll();
        for (Showtime showtime : showtimes) {
            System.out.println("Started At: " + showtime.getStartedAt());
            // 다른 엔티티의 정보도 출력 가능
            System.out.println("Screen Name: " + showtime.getScreen().getName());
            System.out.println("Cinema Name: " + showtime.getScreen().getCinema().getName());
            System.out.println("Region City: " + showtime.getScreen().getCinema().getRegion().getCity());
            System.out.println("Movie Name: " + showtime.getMovie().getMovieNm());
            System.out.println("Rating Grade: " + showtime.getMovie().getRatingGrade());

        }
    }

    @Test
    public void mFindById_test() {
        int id = 1;
        Optional<Showtime> showtime = showtimeRepository.mFindById(id);
        if(showtime.isPresent()){
            System.out.println(showtime.get().getMovie().getMovieNm());
            System.out.println(showtime.get().getMovie().getRatingGrade());
            System.out.println(showtime.get().getStartedAt().toString());
            System.out.println(showtime.get().getScreen().getName());
            System.out.println(showtime.get().getScreen().getCinema().getName());
            System.out.println(showtime.get().getScreen().getCinema().getRegion().getCity());


        }else {
            System.out.println("없어요");
        }
    }
}
