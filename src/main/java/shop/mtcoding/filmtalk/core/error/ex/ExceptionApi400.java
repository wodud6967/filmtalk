package shop.mtcoding.filmtalk.core.error.ex;

// 유효성 검사
public class ExceptionApi400 extends RuntimeException {

    public ExceptionApi400(String message) {
        super(message);
    }
}
