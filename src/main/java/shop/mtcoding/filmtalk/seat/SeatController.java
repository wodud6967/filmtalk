package shop.mtcoding.filmtalk.seat;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.filmtalk.core.util.Resp;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

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
    


/*    //TODO: /api 추가하기
    @GetMapping("/seat/{showtimeId}")
    public @ResponseBody SeatResponse.SeatDTO seatSelect(@PathVariable("showtimeId") Long showtimeId){

        //TODO: 세션의 SHOWTIMEID로 바꾸기
        SeatResponse.SeatDTO seatDTO = seatService.좌석렌더링(showtimeId);

        return seatDTO;

    }*/



    //TODO: /api 추가하기
    @GetMapping("/seat/{showtimeId}")
    public @ResponseBody ResponseEntity<?> seatSelect(@PathVariable("showtimeId") Long showtimeId){

        //TODO: 세션의 SHOWTIMEID로 바꾸기
        SeatResponse.SeatDTO seatDTO = seatService.좌석렌더링(showtimeId);

        return new ResponseEntity<>(seatDTO, HttpStatus.OK);

    }

    @PostMapping("/seat/reservation")
    public String makeReservation(HttpSession session, @RequestParam("showtimeId") Long showtimeId, @RequestParam("totalPrice") String totalPrice){
        //TODO : 세션에서 꺼낸 User정보로 바꾸기
        //User serssionUser = (User) session.getAttribute("user");
        System.out.println("totalPrice " + totalPrice);
        User sessionUser = User.builder().id(1L).build();
        System.out.println(showtimeId);
        seatService.예매등록티켓생성(sessionUser);

        return "성공?";
    }

}
