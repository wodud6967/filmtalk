package shop.mtcoding.filmtalk.cinema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CinemaController {

    @GetMapping("/cinema")
    public String view(){

        return "cinema/veiw";
    }

    @ResponseBody
    @GetMapping("/cineTest")
    public String test(){
        return "테스트 성공ssss";
    }
}
