package shop.mtcoding.filmtalk.mypage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@RequiredArgsConstructor
@Controller
public class MypageController {

    // 결제(예매)내역 페이지
    @GetMapping("/mypage/paymentDetail")
    public String paymentDetail(Model model) {
        List<Map<String, Object>> reservation = new ArrayList<>();

        Map<String, Object> ticket = new HashMap<>();
        ticket.put("date", "2024.09.04 (수)");
        ticket.put("movieTitle", "에이리언: 로물루스");
        ticket.put("price", "14,000");
        ticket.put("reservId", "22462010");
        ticket.put("posterImg", "/img/poster.png");
        ticket.put("showDate", "2024.09.04 (수)");
        ticket.put("showTime", "18:45 ~ 20:45");
        ticket.put("cinema", "센텀시티 6관");
        ticket.put("people", "성인 1");
        ticket.put("seat", "L15");
        ticket.put("paymentDate", "2024-09-04 오후 3:38:08");
        ticket.put("orderPrice", "7,000원");
        ticket.put("discountPrice", "0원");
        ticket.put("couponPrice", "7,000원");
        ticket.put("payPrice", "7,000원");

        reservation.add(ticket);

        model.addAttribute("reservation", reservation);

        return "mypage/paymentDetail";
    }

    // 취소내역 페이지
    @GetMapping("/mypage/paymentCncl")
    public String paymentCncl(Model model) {
        List<Map<String, Object>> reservation = new ArrayList<>();

        Map<String, Object> ticketCncl = new HashMap<>();
        ticketCncl.put("date", "2024.09.04 (수)");
        ticketCncl.put("movieTitle", "에이리언: 로물루스");
        ticketCncl.put("price", "14,000");
        ticketCncl.put("reservId", "22462010");
        ticketCncl.put("cnclDate", "2024.09.04");
        ticketCncl.put("posterImg", "/img/poster.png");
        ticketCncl.put("showDate", "2024-09-04 (수)");
        ticketCncl.put("showTime", "18:45 ~ 20:45");
        ticketCncl.put("cinema", "센텀시티 6관");
        ticketCncl.put("people", "성인 1");
        ticketCncl.put("seat", "L15");
        ticketCncl.put("paymentDate", "2024-09-04 오후 3:38:08");
        ticketCncl.put("orderPrice", "7,000");
        ticketCncl.put("discountPrice", "0");
        ticketCncl.put("couponPrice", "7,000");
        ticketCncl.put("cnclPrice", "0");
        ticketCncl.put("cnclDateTime", "2024-09-04 오후 3:41:29");

        reservation.add(ticketCncl);

        model.addAttribute("reservation", reservation);
        return "mypage/paymentCncl";
    }


    // 1:1 문의하기 페이지
    @GetMapping("/mypage/qnaWrite")
    public String qnaWrite(Model model) {
        model.addAttribute("", "");
        return "mypage/qnaWrite";
    }


    // 1:1 문의내역 리스트 페이지
    @GetMapping("/mypage/qnaList")
    public String qnaList(Model model) {
        model.addAttribute("", "");
        return "mypage/qnaList";
    }

    // 1:1 문의내역 상세보기 페이지
    @GetMapping("/mypage/qnaDetail")
    public String qnaDetail(Model model) {
        model.addAttribute("", "");
        return "mypage/qnaDetail";
    }
}
