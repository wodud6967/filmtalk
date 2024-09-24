package shop.mtcoding.filmtalk.showtime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.mtcoding.filmtalk.screen.Screen;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ShowtimeQueryRepository {
    private final EntityManager em;


}
