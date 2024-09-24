package shop.mtcoding.filmtalk.admin;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public class AdminShotimeRequest {
    @Data
    public static class LoginDTO {

        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
    }
    @Data
    public static class ShowtimeSaveRequest {
        private Long movieId;
        private String time;  // 상영 시작 시간
        private Long screenId;  // 상영관 ID
        private Integer price =10;
        public ShowtimeSaveRequest(){}

        public ShowtimeSaveRequest(Long movieId, String time, Long screenId) {
            this.movieId = movieId;
            this.time = time;
            this.screenId = screenId;
        }
    }


}
