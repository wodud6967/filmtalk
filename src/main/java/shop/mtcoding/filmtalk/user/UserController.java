package shop.mtcoding.filmtalk.user;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class UserController {


    private final HttpSession session;
    private final UserSerivce userSerivce;


    @GetMapping("/logout")
    public String logout() {
        //TODO DFEEF
        session.invalidate(); //  락커의 특정 세션서랍만 날린다.
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid UserRequest.LoginDTO loginDTO, Errors errors) {
        User sessionUser = userSerivce.로그인(loginDTO);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }


    @PostMapping("/join")
    public String join(@Valid UserRequest.JoinDTO joinDTO, Errors errors) {
        userSerivce.회원가입(joinDTO);
        return "redirect:/login-form";
    }


    @GetMapping("/join-form")
    public String joinForm() {

        return "user/join-form";
    }

    @GetMapping("login-form")
    public String loginForm() {
        System.out.println("login-form 메소드 실행됨");
        return "user/login-form";
    }
}
