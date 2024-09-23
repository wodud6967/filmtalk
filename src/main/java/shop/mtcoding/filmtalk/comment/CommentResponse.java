package shop.mtcoding.filmtalk.comment;

import lombok.Data;
import shop.mtcoding.filmtalk.core.util.TimeFormatter;

import java.time.format.DateTimeFormatter;

public class CommentResponse {


    @Data
    public static class DTO {
        private Long Id;
        private String comment;
        private String username;
        private String createdAt;

        public DTO(Comment comment) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.Id = comment.getId();
            this.comment = comment.getContent();
            this.username = comment.getUser().getUsername();
            this.createdAt = TimeFormatter.commentTimeFormat(comment.getCreatedAt());
        }
    }
}
