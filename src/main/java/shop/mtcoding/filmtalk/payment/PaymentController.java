package shop.mtcoding.filmtalk.payment;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        // 예약 ID와 결제 요청 전 고유한 merchant_uid 생성
        String merchantUid = paymentService.generateMerchantUid(saveDTO.getReservationId());

        System.out.println("=============================================================");
        System.out.println("Generated merchant_uid: " + merchantUid);

        // 결제 정보 저장
        saveDTO.setMerchantUid(merchantUid);

        // 결제 서비스 호출
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

        if (reservationId != null) {
            session.setAttribute("sessionReservationId", reservationId);
            session.setAttribute("sessionTotalPrice", sTotalPrice);
            System.out.println("Session에 저장된 reservationId: " + reservationId);
            System.out.println("Session에 저장된 totalPrice: " + sTotalPrice);
        } else {
            System.out.println("ReservationId가 null입니다. 세션에 저장하지 않습니다.");
        }

        session.setAttribute("sessionReservationId", reservationId);
        session.setAttribute("sessionTotalPrice", sTotalPrice);

        System.out.println("Session - reservationId: " + session.getAttribute("sessionReservationId"));
        System.out.println("Session - sessionTotalPrice: " + session.getAttribute("sessionTotalPrice"));

        return "redirect:/api/payment/success";
    }


    @GetMapping("/api/payment/view")
    public String viewPaymentPage(HttpSession session, Model model) {
        Long sessionReservationId = (Long) session.getAttribute("sessionReservationId");
        Double sessionTotalPrice = (Double) session.getAttribute("sessionTotalPrice");

        if (sessionReservationId == null || sessionTotalPrice == null) {
            throw new ExceptionApi404("Reservation or Price data is missing.");
        }

        // merchantUid 생성 (고유 결제 ID)
        String merchantUid = paymentService.generateMerchantUid(sessionReservationId);

        // 예약 정보와 연관된 데이터 조회
        PaymentResponse.PaymentViewDTO paymentData = paymentService.getPaymentViewData(sessionReservationId);

        // 할인금액 0으로 고정 (추후 쿠폰 및 할인권 적용 시 구현 예정)
        int discount = 0;
        // 결제금액 = 상품금액 - 할인금액
        double payPrice = sessionTotalPrice - discount;

        model.addAttribute("paymentData", paymentData);
        model.addAttribute("mTotalPrice", sessionTotalPrice);
        model.addAttribute("discount", discount);
        model.addAttribute("payPrice", payPrice);
        model.addAttribute("merchantUid", merchantUid);

        return "payment/view";
    }



    @GetMapping("/api/payment/success")
    public String paymentSuccess(HttpSession session, Model model) {
        // 세션에서 예약 ID와 총 결제 금액 가져오기
        Long sessionReservationId = (Long) session.getAttribute("sessionReservationId");
        Double sessionTotalPrice = (Double) session.getAttribute("sessionTotalPrice");

        if (sessionReservationId == null || sessionTotalPrice == null) {
            throw new ExceptionApi404("Reservation or Price data is missing.");
        }

        // 예약 정보와 결제 정보를 한 번에 조회
        PaymentResponse.PaymentViewDTO paymentData = paymentService.getPaymentViewData(sessionReservationId);

        // 할인 금액은 0으로 고정 (추후 쿠폰 및 할인 적용 시 수정 가능)
        int discount = 0;
        double payPrice = sessionTotalPrice - discount;

        // 8자리 예매번호 생성
        String bookingNumber = paymentService.generateBookingNumber();

        // 모델에 paymentData 객체 전체 추가
        model.addAttribute("paymentData", paymentData);
        model.addAttribute("mTotalPrice", sessionTotalPrice);  // 총 금액
        model.addAttribute("discount", discount);  // 할인 금액
        // model.addAttribute("payPrice", payPrice);  // 최종 결제 금액
        model.addAttribute("bookingNumber", bookingNumber);

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
