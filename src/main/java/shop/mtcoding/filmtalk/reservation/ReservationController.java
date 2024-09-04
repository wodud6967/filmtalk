package shop.mtcoding.filmtalk.reservation;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;


@RequiredArgsConstructor
@Controller
public class ReservationController {


    private final HttpSession session;
    private final ReservationService reservationService;

    @GetMapping("/reservation")
    public String view(){

        return "reservation/view";
    }

    //TODO 쿼리 테스트
    @GetMapping("/reservation/test")
    public String test(){
        User user =User.builder()
                        .id(1l)
                        .email("wodud6967@naver.com")
                        .phone("01048086967")
                        .password("1234")
                        .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();



        return "reservation/view";
    }
}
