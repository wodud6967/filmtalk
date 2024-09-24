package shop.mtcoding.filmtalk.payment;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
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


    // 세션에 저장
    @PostMapping("/pay/view")
    public String completeReservation(@RequestParam Long reservationId,
                                      @RequestParam Double sTotalPrice,
                                      HttpSession session) {

        // 세션 저장
        session.setAttribute("sessionReservationId", reservationId);
        session.setAttribute("sessionTotalPrice", sTotalPrice);

        System.out.println("Session - reservationId: " + session.getAttribute("sessionReservationId"));
        System.out.println("Session - sessionTotalPrice: " + session.getAttribute("sessionTotalPrice"));

        return "redirect:/payment/view";
    }


    // TODO: 좌석 - 결제 연결 전 테스트용 더미 사용
    @GetMapping("/payment/view")
    public String viewPaymentPage(HttpSession session, Model model) {

        Long sessionReservationId = (Long) session.getAttribute("sessionReservationId");
        Double sessionTotalPrice = (Double) session.getAttribute("sessionTotalPrice");

        if (sessionReservationId == null || sessionTotalPrice == null) {
            throw new ExceptionApi404("Reservation or Price data is missing.");
        }

        // 예약 정보와 연관된 데이터 조회
        PaymentResponse.PaymentViewDTO paymentData = paymentService.getPaymentViewData(sessionReservationId);

        // 할인금액 0으로 고정
        double discount = 0.0;
        // 결제금액은 상품금액에서 할인금액을 뺀 값
        double payPrice = sessionTotalPrice - discount;

        model.addAttribute("paymentData", paymentData);
        model.addAttribute("mTotalPrice", sessionTotalPrice);
        model.addAttribute("discount", discount);
        model.addAttribute("payPrice", payPrice);

        return "payment/view";
    }



    // TODO: 좌석 - 결제 연결되면 밑의 로직 사용
//    @GetMapping("/payment/view")
//    public String viewPaymentPage(HttpSession session, Model model) {
//        // 세션에 reservationId, totalPrice 없으면 더미로 임시 설정
//        Long reservationId = (Long) session.getAttribute("reservationId");
//        Double totalPrice = (Double) session.getAttribute("totalPrice");
//
//        if (reservationId == null || totalPrice == null) {
//            throw new ExceptionApi404("Reservation or Price data is missing.");
//        }
//
//        // 데이터 처리 후 결제 페이지로 전달
//        PaymentResponse.PaymentViewDTO paymentData = paymentService.getPaymentViewData(reservationId);
//        model.addAttribute("paymentData", paymentData);
//        model.addAttribute("totalPrice", totalPrice);
//
//        return "payment/view";  // 결제 페이지로 이동
//    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("reservationId") Long reservationId, Model model) {
        PaymentResponse.PaymentViewDTO paymentViewDTO = paymentService.getPaymentViewData(reservationId);

    // TODO: 좌석 - 결제 연결되면 밑의 로직 사용
//    @GetMapping("/payment/view")
//    public String viewPaymentPage(HttpSession session, Model model) {
//        // 세션에 reservationId, totalPrice 없으면 더미로 임시 설정
//        Long reservationId = (Long) session.getAttribute("reservationId");
//        Double totalPrice = (Double) session.getAttribute("totalPrice");
//
//        if (reservationId == null || totalPrice == null) {
//            throw new ExceptionApi404("Reservation or Price data is missing.");
//        }
//
//        // 데이터 처리 후 결제 페이지로 전달
//        PaymentResponse.PaymentViewDTO paymentData = paymentService.getPaymentViewData(reservationId);
//        model.addAttribute("paymentData", paymentData);
//        model.addAttribute("totalPrice", totalPrice);
//
//        return "payment/view";  // 결제 페이지로 이동
//    }


//    @GetMapping("/payment/success")
//    public String paymentSuccess(@RequestParam("reservationId") Long reservationId, Model model) {
//        PaymentResponse.PaymentViewDTO paymentViewDTO = paymentService.getPaymentViewData(reservationId);
//
//        model.addAttribute("userName", paymentViewDTO.getUsername());
//        model.addAttribute("posterImg", paymentViewDTO.getMoviePosterUrl());
//        model.addAttribute("reservId", paymentViewDTO.getReservationId());  // 예매번호 (8자리)
//        model.addAttribute("showTime", paymentViewDTO.getShowtime());
//        model.addAttribute("cinema", paymentViewDTO.getCinemaName() + " " + paymentViewDTO.getScreenName());
//        model.addAttribute("people", "성인 " + paymentViewDTO.getPeople());
//        model.addAttribute("seat", paymentViewDTO.getSeats());  // 좌석 정보 처리
//        model.addAttribute("price", paymentViewDTO.getPrice());
//
//        return "payment/success";
//    }




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
