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
        ticket.put("date", "2024.09.12 (목)");
        ticket.put("movieTitle", "인터스텔라");
        ticket.put("price", "28,000");
        ticket.put("reservId", "12345678");
        ticket.put("posterImg", "/img/inter.jpg");
        ticket.put("showDate", "2024.09.12 (목)");
        ticket.put("showTime", "14:00 ~ 16:30");
        ticket.put("cinema", "서면롯데시네마 Screen 1");
        ticket.put("people", "성인 2");
        ticket.put("seat", "1, 4");
        ticket.put("paymentDate", "2024-09-12 오후 2:43:44");
        ticket.put("orderPrice", "28,000원");
        ticket.put("discountPrice", "0원");
        ticket.put("couponPrice", "28,000원");
        ticket.put("payPrice", "28,000원");

        reservation.add(ticket);

        model.addAttribute("reservation", reservation);

        return "mypage/paymentDetail";
    }

    // 취소내역 페이지
    @GetMapping("/mypage/paymentCncl")
    public String paymentCncl(Model model) {
        List<Map<String, Object>> reservation = new ArrayList<>();

        Map<String, Object> ticketCncl = new HashMap<>();
        ticketCncl.put("date", "2024.09.12 (목)");
        ticketCncl.put("movieTitle", "인터스텔라");
        ticketCncl.put("price", "28,000");
        ticketCncl.put("reservationId", "12345678");
        ticketCncl.put("cnclDate", "2024.09.12");
        ticketCncl.put("posterImg", "/img/inter.jpg");
        ticketCncl.put("showDate", "2024-09-02 (목)");
        ticketCncl.put("showTime", "14:00 ~ 16:30");
        ticketCncl.put("cinema", "서면롯데시네마 Screen 1");
        ticketCncl.put("people", "성인 2");
        ticketCncl.put("seat", "1, 4");
        ticketCncl.put("paymentDate", "2024-09-12 오후 2:23:44");
        ticketCncl.put("orderPrice", "7,000");
        ticketCncl.put("discountPrice", "0");
        ticketCncl.put("couponPrice", "7,000");
        ticketCncl.put("cnclPrice", "0");
        ticketCncl.put("cnclDateTime", "2024-09-12 오후 6:41:29");

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
