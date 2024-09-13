package shop.mtcoding.filmtalk.admin;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/admin/dashboard")
    public String dashBoard(){
        return "admin/dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String NotAuthenticatedDashBoard(){

        return "admin/dashboard";
    }

    @GetMapping("/admin")
    public String login(){
        return "admin/login-form";
    }

    @GetMapping("/admin/member")
    public String member(){
        return "admin/member";
    }
    @GetMapping("/admin/cinema")
    public String cinema(){
        return "admin/cinema-add";
    }
    @GetMapping("/admin/movie")
    public String movie(HttpServletRequest request){
        List<AdminResponse.MovieDTO> rawMovies = adminService.API영화보여주기();
        request.setAttribute("models", rawMovies);
        return "admin/movie";
    }
    @GetMapping("/admin/showtime")
    public String showtime(){
        return "admin/showtime";
    }



    // TODO: qna 페이지 DTO 까지 건들이려니까 복잡해서 임시로 컨트롤러에서 포문으로 리스트 출력
    @GetMapping("/admin/qnaList")
    public String qnaList(Model model) {
        // 임시 데이터
        List<Map<String, Object>> qnaList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Map<String, Object> qna = new HashMap<>();
            qna.put("no", i);
            qna.put("userId", "user" + i);
            qna.put("queryType", "영화 문의");
            qna.put("title", "문의 제목 " + i);
            qna.put("content", "문의 내용 " + i);
            qna.put("date", "2023-08-02");
            qna.put("answerStatus", (i % 2 == 0) ? "Y" : "N");  // 짝수면 답변 완료, 홀수면 미답변 - 임시
            qna.put("answerDate", (i % 2 == 0) ? "2023-08-03" : "-");
            qna.put("answerer", (i % 2 == 0) ? "관리자" : "-");
            qnaList.add(qna);
        }

        // 페이징 더미
        List<Integer> pagination = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            pagination.add(i);
        }

        model.addAttribute("qnaList", qnaList);
        model.addAttribute("pagination", pagination);

        return "admin/qnaList";
    }

    // 1:1 문의 상세 페이지
    @GetMapping("/admin/qnaDetail")
    public String qnaDetail(Model model) {
        // TODO: 임시 데이터를 추가
        model.addAttribute("questionTitle", "시설이 너무 더워요!");
        model.addAttribute("queryType", "시설 문의");
        model.addAttribute("userId", "user04");
        model.addAttribute("date", "2023-08-02");
        model.addAttribute("content", "에어컨이 너무 약하게 나와요. 시원하게 가동 좀 해주세요.");
        model.addAttribute("answerContent", "");

        return "admin/qnaDetail";
    }

}
