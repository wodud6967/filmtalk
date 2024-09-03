package shop.mtcoding.filmtalk.core.error.ex;


//인증관련 badrequst
public class Exception401 extends RuntimeException {

    public Exception401(String message) {
        super(message);
    }
}
