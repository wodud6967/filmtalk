package shop.mtcoding.filmtalk.core.error;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import shop.mtcoding.filmtalk.core.error.ex.Exception400;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi400;


@Component
@Aspect //AOP 등록
public class GlobalValidationHandler {

    @Before("execution(* shop.mtcoding.filmtalk.admin.AdminController.saveMovie(..))")
    public void apiValidation(JoinPoint jp) {
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
                    for (FieldError error : errors.getFieldErrors()) {
                        throw new ExceptionApi400(error.getDefaultMessage() + " : " + error.getField());

                    }
                }
            }
        }
    }

    //@Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping)")
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void vaildCheck(JoinPoint jp) {
        //public String save(@Valid BoardRequest.SaveDTO saveDTO, Errors errors) { //스프링 기본전략 x-www-form-urlencoded 파싱
        //
        Object[] args = jp.getArgs();//매개변수
       /* System.out.println("사이즈 : " + args.length);
        for (Object arg : args) {
            System.out.println(arg);
        }*/

        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
                    for (FieldError error : errors.getFieldErrors()) {
                        throw new Exception400(error.getDefaultMessage() + " : " + error.getField());

                    }
                }
            }
        }
    }


}
