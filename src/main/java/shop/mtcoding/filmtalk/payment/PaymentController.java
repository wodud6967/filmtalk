package shop.mtcoding.filmtalk.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.filmtalk.core.util.Resp;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.reservation.ReservationService;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class PaymentController {

    private final PaymentService paymentService;
    private final ReservationService reservationService;

    @PostMapping("/payment")
    public ResponseEntity<?> validationPayment(@RequestBody PaymentRequest.SaveDTO saveDTO) {
        paymentService.save(saveDTO);
        // "http://localhost/payment?imp_uid=imp_359888216361&merchant_uid=255eae01-2b82-4cbf-b40b-49b12d793703&imp_success=true"
        return new ResponseEntity<>(Resp.ok(null), HttpStatus.OK);
    }


    @GetMapping("/payment/view")
    public String paymentView(Model model, @RequestParam("reservationId") Long reservationId) {
        PaymentResponse.PaymentViewDTO paymentViewDTO = paymentService.getPaymentViewData(reservationId);

        model.addAttribute("posterImg", paymentViewDTO.getMoviePosterUrl());
        model.addAttribute("movieTitle", paymentViewDTO.getMovieTitle());
        model.addAttribute("showTime", paymentViewDTO.getShowtime());
        model.addAttribute("cinema", paymentViewDTO.getCinemaName() + " " + paymentViewDTO.getScreenName());
        model.addAttribute("people", "성인 " + paymentViewDTO.getPeople());
        model.addAttribute("seat", String.join(", ", paymentViewDTO.getSeats()) );
        model.addAttribute("price", paymentViewDTO.getPrice());
        model.addAttribute("payPrice", paymentViewDTO.getPayPrice());
        model.addAttribute("userName", paymentViewDTO.getUsername());

        return "payment/view";
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("reservationId") Long reservationId, Model model) {
        PaymentResponse.PaymentViewDTO paymentViewDTO = paymentService.getPaymentViewData(reservationId);

        model.addAttribute("userName", paymentViewDTO.getUsername());
        model.addAttribute("posterImg", paymentViewDTO.getMoviePosterUrl());
        model.addAttribute("reservId", paymentViewDTO.getReservationId());  // 예매번호 (8자리)
        model.addAttribute("showTime", paymentViewDTO.getShowtime());
        model.addAttribute("cinema", paymentViewDTO.getCinemaName() + " " + paymentViewDTO.getScreenName());
        model.addAttribute("people", "성인 " + paymentViewDTO.getPeople());
        model.addAttribute("seat", paymentViewDTO.getSeats());  // 좌석 정보 처리
        model.addAttribute("price", paymentViewDTO.getPrice());

        return "payment/success";
    }




    // 임시 더미
//        model.addAttribute("posterImg", "/img/inter.jpg");
//        model.addAttribute("movieTitle", "인터스텔라");
//        model.addAttribute("showTime", "2024-09-12 (목) 12:00 ~ 16:30");
//        model.addAttribute("cinema", "서면롯데시네마 Screen 1");
//        model.addAttribute("people", "성인 2");
//        model.addAttribute("seat", "1, 4");
//        model.addAttribute("price", "10"); // TODO: 테스트를 위해 최소금액으로 진행
//        model.addAttribute("discount", "0");
//        model.addAttribute("payPrice", "10");
//        model.addAttribute("userName", "신민재");
//        model.addAttribute("email", "example@example.com");
//        model.addAttribute("phone", "010-1234-5678");
//        return "payment/view";
//    }

//    @GetMapping("/payment/success")
//    public String paymentSuccess(Model model) {
//        // 임시 더미
//        model.addAttribute("userName", "신민재");
//        model.addAttribute("posterImg", "/img/inter.jpg");
//        model.addAttribute("reservationId", "12345678");
//        model.addAttribute("showTime", "2024-09-12 (목) 12:00 ~ 16:30");
//        model.addAttribute("cinema", "서면롯데시네마 Screen 1");
//        model.addAttribute("people", "성인 2");
//        model.addAttribute("seat", "1, 4");
//        model.addAttribute("price", "100");
//        model.addAttribute("discount", "0");
//        model.addAttribute("coupon", "0");
//        model.addAttribute("payPrice", "100");
//
//        return "payment/success";
//    }

    // TODO: 예매 파트 완료 시 밑의 model에 담아서 뷰로 넘김
//    @GetMapping("/payment/success")
//    public String paymentSuccess(@RequestParam("reservationId") Long reservationId, Model model) {
//        // 결제 완료 정보 로드 로직
//        PaymentResponse response = paymentService.getPaymentSuccess(reservationId);
//        model.addAttribute("paymentDetails", response);
//        return "payment/success";
//    }


    // TODO: UUID 로 진행
//    @GetMapping("/payment/success")
//    public String paymentSuccess(@RequestParam("reservationId") String reservationId, Model model) {
//        PaymentResponse response = paymentService.getPaymentSuccessByUUID(reservationId);
//        model.addAttribute("paymentDetails", response);
//        return "payment/success";
//    }


}
