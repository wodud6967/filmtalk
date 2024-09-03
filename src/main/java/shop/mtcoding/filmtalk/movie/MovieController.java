package shop.mtcoding.filmtalk.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MovieController {

    @GetMapping("/")
    public String home(){

        return "movie/view";
    }
}
