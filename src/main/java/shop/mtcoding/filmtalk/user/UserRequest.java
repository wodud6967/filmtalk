package shop.mtcoding.filmtalk.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {

        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
        @NotEmpty
        @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해주세요")
        private String email;

        //DTO -> UserObject
        public User toEntity() { //insert할때만
            return User.builder().username(username).password(password).email(email).build();
        }
    }

    @Data
    public static class LoginDTO {

        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
    }
}
