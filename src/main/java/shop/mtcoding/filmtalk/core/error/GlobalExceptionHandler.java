package shop.mtcoding.filmtalk.core.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.filmtalk.core.error.ex.*;
import shop.mtcoding.filmtalk.core.util.Script;


@RestControllerAdvice
public class GlobalExceptionHandler {

    //유효성 검사 실패 (잘못된 클라이언트의 요청)
    @ExceptionHandler(Exception400.class)
    public String ex400(Exception e) {

        return Script.back(e.getMessage());
    }

    // 인증 실패(클라이언트가 인증없이 요청했거나, 인증을 하거나 실패했거나)
    @ExceptionHandler(Exception401.class)
    public String ex401(Exception e) {
        return Script.href("인증되지 않았스니다.", "login-form");
    }

    // 권한 실패 (인증은 되어 있는데 삭제하려는 게시글이 내가 적은게 아니다.)
    @ExceptionHandler(Exception403.class)
    public String ex402(Exception e) {
        return Script.back(e.getMessage());
    }

    // 서버에서 리스스(자원) 찾을 수 없을 때
    @ExceptionHandler(Exception404.class)
    public String ex404(Exception e) {
        return Script.back(e.getMessage());
    }

    // 서버에서 심각한 오류가 발생 했을 때(알고 있을 때)
    @ExceptionHandler(Exception500.class)
    public String ex500(Exception e) {
        return Script.back(e.getMessage());
    }

    // 서버에서 심각한 오류가 발생 했을 때(모를 때)
    @ExceptionHandler(Exception.class)
    public String ex(Exception e) {
        return Script.back(e.getMessage());
    }

}
