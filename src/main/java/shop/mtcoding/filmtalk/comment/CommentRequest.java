package shop.mtcoding.filmtalk.comment;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.user.User;

public class CommentRequest {

    @Data
    public static class  SaveDTO {
        private Long movieId;
        @NotEmpty(message = "내용은 필수 입력 항목입니다.")
        private String comment;

        public Comment toEntity(User sessionUser, Movie movie) {
            return Comment.builder()
                    .content(comment)
                    .user(sessionUser)
                    .movie(movie)
                    .build();

        }

    }
}
