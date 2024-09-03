package shop.mtcoding.filmtalk.cinema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CinemaController {

    @GetMapping("/cinema")
    public String view(){

        return "cinema/veiw";
    }
}
