package shop.mtcoding.filmtalk.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.filmtalk.user.User;
import shop.mtcoding.filmtalk.user.UserQueryRepository;

@DataJpaTest
@Import(ReservationQueryRepository.class)
public class ReservationQueryRepositoryTest {

    @Autowired
    public ReservationQueryRepository reservationRepository;


}
