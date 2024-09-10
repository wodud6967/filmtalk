package shop.mtcoding.filmtalk.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String movie(){
        return "admin/movie";
    }
    @GetMapping("/admin/showtime")
    public String showtime(){
        return "admin/showtime";
    }
}
