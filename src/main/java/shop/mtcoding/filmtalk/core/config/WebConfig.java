package shop.mtcoding.filmtalk.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import shop.mtcoding.filmtalk.core.interceptor.AdminInterceptor;
import shop.mtcoding.filmtalk.core.interceptor.LoginInterceptor;


@Configuration // Ioc에 저장됨 메모리에 띄운다.
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")  // 관리자 로그인 페이지 예외 처리
                .excludePathPatterns("/admin/login");  // 관리자 로그인 처리 POST 요청 예외 처리

    }
}
