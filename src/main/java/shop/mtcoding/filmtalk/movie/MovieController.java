package shop.mtcoding.filmtalk.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MovieController {

    //열심히 만들겠습니다!
    @GetMapping("/")
    public String home(){

        return "movie/view";
    }
    @GetMapping("/movie/1")
    public String detail(){
        return "movie/detail";
    }
}
