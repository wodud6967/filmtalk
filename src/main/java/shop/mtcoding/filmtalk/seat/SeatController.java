package shop.mtcoding.filmtalk.seat;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class SeatController {

    private final SeatService seatService;
    
    //TODO: /api 추가하기
    @GetMapping("/seat")
    public String seat(HttpSession session, HttpServletRequest request) {
        //TODO : 세션에서 꺼낸 USERNAME으로 바꾸기
        String username = "ssar";
        //TODO: 세션의 SHOWTIMEID로 바꾸기
        Long showtimeId = 1L;
        SeatResponse.DTO model = seatService.좌석메인화면(showtimeId);

        request.setAttribute("model", model);
        return "seat/view";
    }

}
