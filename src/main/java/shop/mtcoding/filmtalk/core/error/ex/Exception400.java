package shop.mtcoding.filmtalk.core.error.ex;


//유효성 검사 badrequst
public class Exception400 extends RuntimeException {

    public Exception400(String message) {
        super(message);
    }
}
