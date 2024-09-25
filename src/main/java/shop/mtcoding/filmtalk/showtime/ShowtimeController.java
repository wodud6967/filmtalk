package shop.mtcoding.filmtalk.showtime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.filmtalk.core.util.Resp;
import shop.mtcoding.filmtalk.region.Region;
import shop.mtcoding.filmtalk.region.RegionService;
import shop.mtcoding.filmtalk.user.UserSerivce;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final RegionService regionService;
    private final HttpSession session;

    @GetMapping("/reservation/api/goSeat/{showtimeId}")
    public ResponseEntity<?> goSeat(@PathVariable("showtimeId") Long showtimeId) {
        session.setAttribute("showtimeId", showtimeId);
        return ResponseEntity.ok(Resp.ok(null));
    }

    @GetMapping("/reservation/movie/{date}/{id}")
    public ResponseEntity<?> dats(@PathVariable("date") Long date,@PathVariable("id")Long id ){
        List<ShowtimeResponse.ShowTimeDTO> dateList = showtimeService.날짜보기(date,id);
        return ResponseEntity.ok(Resp.ok(dateList));
    }

    @GetMapping("/reservation/cinema/{id}")
    public ResponseEntity<?> movies(@PathVariable("id") Long id){
        List<ShowtimeResponse.MovieDTO> movieList = showtimeService.영화관영화보기(id);
        return ResponseEntity.ok(Resp.ok(movieList));
    }

    @GetMapping("/reservation/region/{id}")
    public ResponseEntity<?> view(@PathVariable("id") Long id) {
       ShowtimeResponse.RegionDTO regionList = showtimeService.지역영화관보기(id);
       return ResponseEntity.ok(Resp.ok(regionList));
    }

    @GetMapping("/reservation")
    public String view(HttpServletRequest request) {
        List<Region> regionList = regionService.지역보기();
        request.setAttribute("models", regionList);
        return "reservation/view";
    }

}
