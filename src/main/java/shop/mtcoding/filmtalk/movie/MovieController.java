package shop.mtcoding.filmtalk.movie;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.mtcoding.filmtalk.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MovieController {
    private final MovieService movieService;
    private final HttpSession session;

    //열심히 만들겠습니다!
    @GetMapping("/")
    public String list(HttpServletRequest request) {
        List<MovieResponse.ListDTO> movieList = movieService.영화메인목록보기();
        request.setAttribute("models", movieList);

        return "movie/view";
    }
    @GetMapping("/movie/more")
    public String more(HttpServletRequest request) {
        List<MovieResponse.ListDTO> movieList = movieService.영화더보기();
        request.setAttribute("models", movieList);

        return "movie/more";
    }

    @GetMapping("/movie/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        MovieResponse.DetailDTO movie = movieService.영화상세보기(id, sessionUser);
        request.setAttribute("model", movie);

        return "movie/detail";
    }
}
