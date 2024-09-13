package shop.mtcoding.filmtalk.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.filmtalk.core.util.Resp;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<?> validationPayment(@RequestBody PaymentRequest.SaveDTO saveDTO) {
        paymentService.save(saveDTO);
        // "http://localhost/payment?imp_uid=imp_359888216361&merchant_uid=255eae01-2b82-4cbf-b40b-49b12d793703&imp_success=true"
        return new ResponseEntity<>(Resp.ok(null), HttpStatus.OK);
    }


    @GetMapping("/payment/view")
    public String paymentView(Model model) {
        // 임시 더미
        model.addAttribute("reservationId", UUID.randomUUID().toString());
        model.addAttribute("posterImg", "/img/inter.jpg");
        model.addAttribute("movieTitle", "인터스텔라");
        model.addAttribute("showTime", "2024-09-12 (목) 12:00 ~ 16:30");
        model.addAttribute("cinema", "서면롯데시네마 Screen 1");
        model.addAttribute("people", "성인 2");
        model.addAttribute("seat", "1, 4");
        model.addAttribute("price", "10"); // TODO: 테스트를 위해 최소금액으로 진행
        model.addAttribute("discount", "0");
        model.addAttribute("payPrice", "10");
        model.addAttribute("userName", "신민재");
        model.addAttribute("email", "example@example.com");
        model.addAttribute("phone", "010-1234-5678");
        return "payment/view";
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(Model model) {
        // 임시 더미
        model.addAttribute("userName", "신민재");
        model.addAttribute("posterImg", "/img/inter.jpg");
        model.addAttribute("reservationId", "12345678");
        model.addAttribute("showTime", "2024-09-12 (목) 12:00 ~ 16:30");
        model.addAttribute("cinema", "서면롯데시네마 Screen 1");
        model.addAttribute("people", "성인 2");
        model.addAttribute("seat", "1, 4");
        model.addAttribute("price", "100");
        model.addAttribute("discount", "0");
        model.addAttribute("coupon", "0");
        model.addAttribute("payPrice", "100");

        return "payment/success";

    }

}
