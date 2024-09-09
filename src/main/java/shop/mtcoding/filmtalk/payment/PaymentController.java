package shop.mtcoding.filmtalk.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PaymentController {
    @GetMapping("/payment/view")
    public String paymentView(Model model) {
        // 임시 더미
        model.addAttribute("posterImg", "/img/poster.png");
        model.addAttribute("movieTitle", "에이리언 : 로물루스");
        model.addAttribute("showTime", "2024-09-04 (수) 18:45 ~ 20:45");
        model.addAttribute("cinema", "센텀시티 6관 - 2D");
        model.addAttribute("people", "성인 1");
        model.addAttribute("seat", "L15");
        model.addAttribute("price", "14,000원");
        model.addAttribute("discount", "0 원");
        model.addAttribute("payPrice", "14,000원");
        return "payment/view";
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(Model model) {
        // 임시 더미
        model.addAttribute("userName", "신민재");
        model.addAttribute("posterImg", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
        model.addAttribute("", "");
    }

}
