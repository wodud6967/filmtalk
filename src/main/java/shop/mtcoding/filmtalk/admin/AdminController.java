package shop.mtcoding.filmtalk.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.filmtalk.core.error.validAnno.ValidateApi;
import shop.mtcoding.filmtalk.core.util.Resp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final HttpSession session;
    private final AdminService adminService;




    @PostMapping("/admin/login")
    public String adminLogin(AdminShotimeRequest.LoginDTO loginDTO){

        Admin sessionAdmin = adminService.로그인(loginDTO);
        session.setAttribute("sessionAdmin", sessionAdmin);
        return "admin/dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String NotAuthenticatedDashBoard(){
        Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");
        // adminService.상영관등록();

        return "admin/dashboard";
    }

    @GetMapping("/admin")
    public String login(){
        return "admin/login-form";
    }

    @GetMapping("/admin/member")
    public String member(HttpServletRequest request){
        AdminMemberResponse models = adminService.관리자리스트보여주기();
        request.setAttribute("models", models);
        return "admin/member";
    }
    @GetMapping("/admin/test/member")
    public ResponseEntity<AdminMemberResponse> testMember() {
        // 서비스에서 AdminMemberResponse 객체 가져오기
        AdminMemberResponse models = adminService.관리자리스트보여주기();

        // ResponseEntity로 반환
        return ResponseEntity.ok(models);
    }

    @GetMapping("/admin/movie")
    public String movie(HttpServletRequest request) {
        List<AdminResponse.MovieDTO> RawMovies = adminService.API영화리스트보여주기();
        request.setAttribute("models", RawMovies);
        return "admin/movie";
    }

    @ValidateApi
    @PostMapping("admin/movie/save")
    public ResponseEntity<?> saveMovie(@Valid @RequestBody AdminRequest.SaveMovieDTO saveMovieDTO, Errors errors) {
        adminService.영화등록하기(saveMovieDTO);
        return ResponseEntity.ok(Resp.ok(null));
    }

    @GetMapping("/admin/movie/{movieNm}")
    public String movie(@PathVariable String movieNm, HttpServletRequest request) {
        AdminResponse.MovieDTO Movie = adminService.API영화상세보기(movieNm);
        request.setAttribute("model", Movie);
        return "admin/movie-detail";

    }
    @GetMapping("/admin/movie/owned")
    public String ownedMovie(@RequestParam(required = false) String movieNm,
                             @RequestParam(required = false) String director,
                             @RequestParam(required = false) String nationNm,
                             @RequestParam(required = false) String company,
                             @RequestParam(required = false) String ratingGrade,
                             HttpServletRequest request) {
        List<AdminResponse.OwnedMovieDTO> OwnedMovie = adminService.보유중인영화리스트보여주기(movieNm, director, nationNm, company, ratingGrade);
        request.setAttribute("models", OwnedMovie);
        return "admin/movie-owned";
    }

    @GetMapping("/admin/movie/owned/{id}")
    public String ownedMovie(@PathVariable int id, HttpServletRequest request) {
        AdminResponse.OwnedMovieDetailDTO movie = adminService.보유중인영화상세보기(id);
        request.setAttribute("model", movie);
        return "admin/movie-owned-detail";
    }
    @PutMapping("/admin/movie/owned/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @Valid @RequestBody AdminRequest.SaveMovieDTO saveMovieDTO, Errors errors) {
        adminService.보유중인영화수정하기(id, saveMovieDTO);
        return ResponseEntity.ok(Resp.ok(null));

    }

    @DeleteMapping("/admin/movie/owned/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        adminService.보유중인영화삭제하기(id);
        return ResponseEntity.ok(Resp.ok(null));
    }

    ///admin/screen/${screenId}/shotimeForm?date=${selectedDate}
    @GetMapping("/admin/screen/{screenId}/shotimeForm")
    public ResponseEntity<?> saveShowtimeForm(
            @PathVariable Long screenId,
            @RequestParam("date") String selectedDate) {

        // selectedDate를 LocalDate로 변환
        LocalDate date = LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 필요한 로직 추가

        return ResponseEntity.ok("Showtime form data received successfully!");
    }


    @PostMapping("/admin/showtime")
    public String saveShowtime(@ModelAttribute AdminShotimeRequest.ShowtimeSaveRequest req) {


        // 상영관 등록 처리
        int day = adminService.상영관등록하기(req);

        // 리다이렉트로 /admin/showtime 페이지로 이동
        return "redirect:/admin/showtime/"+ day;
    }


    @GetMapping("/admin/showtimes") //비동기날짜
    public ResponseEntity<?> getShowtimes(@RequestParam("date") String date) {

        Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");
        LocalDate selectedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 해당 날짜에 대한 상영 스케줄을 가져옴
        AdminShowtimeResponse.CinemaScheduleWithMoviesDTO cinemaSchedule = adminService.상영관별상영스케줄(sessionAdmin, selectedDate);

        return ResponseEntity.ok(Resp.ok(cinemaSchedule));
    }

    @GetMapping("/admin/showtime/{day}")
    public String showtime(@PathVariable("day") int day, HttpServletRequest request, Model model) {
        Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");

        // 12일부터 시작하는 날짜 리스트 생성
        LocalDate startDate = LocalDate.of(2024, 9, 12);
        LocalDate selectedDate = LocalDate.of(2024, 9, day); // URL에서 선택된 날짜 사용
        LocalDate today = startDate; // 12일을 "오늘"로 취급

        List<Map<String, Object>> dateList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDate currentDate = startDate.plusDays(i);  // 12일부터 7일간 생성

            Map<String, Object> dateMap = new HashMap<>();
            dateMap.put("formattedDate", currentDate.format(DateTimeFormatter.ofPattern("dd")));  // "dd" 형식
            dateMap.put("formattedDay", currentDate.format(DateTimeFormatter.ofPattern("E", Locale.KOREAN)));  // 요일
            dateMap.put("isToday", currentDate.equals(selectedDate));  // URL에서 선택된 날짜를 기준으로 오늘 처리
            dateMap.put("fullDate", currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));  // yyyy-MM-dd 형식

            dateList.add(dateMap);
        }

        AdminShowtimeResponse.CinemaScheduleWithMoviesDTO cinemaSchedule = adminService.상영관별상영스케줄(sessionAdmin, selectedDate);
        // DTO 상태를 확인
        for (int i = 0; i < cinemaSchedule.getCinemaSchedule().getScreens().size(); i++) {
            System.out.println("Screen " + (i + 1) + " can add showtime: " + cinemaSchedule.getCinemaSchedule().getScreens().get(i).getCanAddShowtime());
        }
        model.addAttribute("dates", dateList);  // 생성된 날짜 리스트를 모델에 추가
        request.setAttribute("model", cinemaSchedule);

        return "admin/showtime";
    }
    //TODO json변환테스트용
    @GetMapping("/admin/test/showtime")
    public ResponseEntity<?> showtimetest() {
        Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");
        int cinemaId = 1;
        LocalDate startDate = LocalDate.of(2024, 9, 12);
        // DTO 생성
        AdminShowtimeResponse.CinemaScheduleWithMoviesDTO cinemaSchedule = adminService.상영관별상영스케줄(sessionAdmin, startDate);
        // DTO 상태를 확인
        for (int i = 0; i < cinemaSchedule.getCinemaSchedule().getScreens().size(); i++) {
            System.out.println("Screen " + (i + 1) + " can add showtime: " + cinemaSchedule.getCinemaSchedule().getScreens().get(i).getCanAddShowtime());
        }

        // JSON 형식으로 DTO 반환
        return ResponseEntity.ok(cinemaSchedule);
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
