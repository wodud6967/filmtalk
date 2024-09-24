package shop.mtcoding.filmtalk.seat;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.filmtalk.core.util.Resp;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/api")
public class SeatController {

    private final SeatService seatService;
    private final HttpSession session;

    @GetMapping("/seat")
    public String seat(HttpServletRequest request) {
        long showtimeId = (long) session.getAttribute("showtimeId");
        SeatResponse.DTO model = seatService.좌석메인화면(showtimeId);
        request.setAttribute("model", model);
        return "seat/view";
    }

    // TODO: 데이터 확인용. 나중에 지우기
    @GetMapping("/seatRest")
    public @ResponseBody SeatResponse.DTO seatRest(HttpServletRequest request) {
        long showtimeId = (long) session.getAttribute("showtimeId");
        SeatResponse.DTO model = seatService.좌석메인화면(showtimeId);
        return model;
    }


    @GetMapping("/api/seat/{showtimeId}")
    public @ResponseBody ResponseEntity<?> seatSelect(@PathVariable("showtimeId") Long showtimeId){
        System.out.println("1");
        System.out.println("좌석 렌더링용 showtimeId " + showtimeId);
        SeatResponse.SeatDTO seatDTO = seatService.좌석렌더링(showtimeId);
        return new ResponseEntity<>(Resp.ok(seatDTO), HttpStatus.OK);
    }

    @PostMapping("/api/seat/reservation")
    public String makeReservation(HttpSession session, @RequestParam("showtimeId") Long showtimeId, @RequestParam("totalPrice") String totalPrice, @RequestParam("selectedSeatsIds") List<Long> selectedSeatsIds){
        //System.out.println("---------------controller----------");
        User sessionUser = (User) session.getAttribute("sessionUser");
        //System.out.println("selectedSeats: " + selectedSeatsIds);
        //System.out.println("totalPrice " + totalPrice);
        Showtime showtime = Showtime.builder().id(showtimeId).build();
        Long reservationId = seatService.예매등록티켓생성(sessionUser, showtime, selectedSeatsIds);
        session.setAttribute("sessionReservationId", reservationId);

        double d = Double.parseDouble(totalPrice);
        session.setAttribute("sessionTotalPrice", d);
        //System.out.println("세션에 저장된 reservationId : " + session.getAttribute("reservationId"));
        System.out.println("세션에 저장된 reservationId : " + session.getAttribute("sessionReservationId"));
        System.out.println("세션에 저장된 showtimeId : " + session.getAttribute("showtimeId"));
        return "redirect:/api/payment/view";
    }

}