package shop.mtcoding.filmtalk.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.filmtalk.admin.Admin;
import shop.mtcoding.filmtalk.core.error.ex.Exception401;
import shop.mtcoding.filmtalk.user.User;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");

        if (sessionAdmin == null) {
            throw new Exception401("인증되지 않았어요");
        }

        return true;
    }


}
