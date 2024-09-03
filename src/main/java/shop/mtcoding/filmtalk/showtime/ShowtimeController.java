package shop.mtcoding.filmtalk.showtime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import shop.mtcoding.filmtalk.user.UserSerivce;

@RequiredArgsConstructor
@Controller
public class ShowtimeController {

    private final ShowtimeService showtimeService;
}
