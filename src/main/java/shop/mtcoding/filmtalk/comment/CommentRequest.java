package shop.mtcoding.filmtalk.comment;

import lombok.Data;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.user.User;

public class CommentRequest {

    @Data
    public static class  SaveDTO {
        private Long movieId;
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
