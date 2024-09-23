package shop.mtcoding.filmtalk.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.user.User;
import shop.mtcoding.filmtalk.user.UserRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ReservationRepositoryTest {
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void save_test(){
        //given
        User user = User.builder().id(1L).username("ssar").build();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //when
        reservationRepository.save(Reservation.builder().user(user).createdAt(timestamp).build());

        //then
        System.out.println(reservationRepository.findById(1L).get().getUser().getUsername());


    }

}
