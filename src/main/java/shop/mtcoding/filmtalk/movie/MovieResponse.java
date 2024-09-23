package shop.mtcoding.filmtalk.movie;

import lombok.Data;
import shop.mtcoding.filmtalk.comment.Comment;
import shop.mtcoding.filmtalk.core.util.TimeFormatter;
import shop.mtcoding.filmtalk.still.Still;
import shop.mtcoding.filmtalk.user.User;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {

    @Data
    public static class ListDTO {
        private Long id;
        private String ratingGrade;
        private String posterUrl;
        private String movieNm;
        private Integer runtime;

        public ListDTO(Movie movie) {
            this.id = movie.getId();
            this.ratingGrade = movie.getRatingGrade();
            this.movieNm = movie.getMovieNm();
            this.runtime = movie.getRuntime();
            this.posterUrl = movie.getPosterUrls().get(0).getUrl();

        }
    }
    @Data
    public static class DetailDTO{
        private Long id;
        private String movieNm;
        private String openDt;
        private Integer runtime;
        private String ratingGrade;
        private String posterUrl;
        private String vodUrl;
        private String plot;
        private String genreNm;
        private String director;
        private String actorNm;
        private List<StillDTO> stillUrls = new ArrayList<>();
        private List<CommentDTO> comments = new ArrayList<>();

        public DetailDTO(Movie movie, User sessionUser) {
            this.id = movie.getId();
            this.movieNm = movie.getMovieNm();
            this.openDt = movie.getOpenDt();
            this.runtime = movie.getRuntime();
            this.ratingGrade = movie.getRatingGrade();
            this.posterUrl = movie.getPosterUrls().get(0).getUrl();
            this.vodUrl = movie.getVodUrl();
            this.plot = movie.getPlot();
            this.genreNm = movie.getGenreNm();
            this.director = movie.getDirector();
            this.actorNm = movie.getActorNm();
            for(Still still : movie.getStillUrls()){
                stillUrls.add(new StillDTO(still));
            }
            for(Comment comment : movie.getComments()){
                comments.add(new CommentDTO(comment, sessionUser));
            }
        }

        @Data
        public class StillDTO {
            private Long id;
            private String url;

            public StillDTO(Still still) {
                this.id = still.getId();
                this.url = still.getUrl();

            }
        }

        @Data
        public class CommentDTO {
            private Long id;
            private String content;
            private String username;
            private boolean isOwner;
            private String createdAt;

            public CommentDTO(Comment comment, User sessionUser) {
                this.id = comment.getId();
                this.content = comment.getContent();
                this.username = comment.getUser().getUsername();
                this.isOwner =false;
                this.createdAt = TimeFormatter.commentTimeFormat(comment.getCreatedAt());

                if (sessionUser != null) {
                    if (comment.getUser().getId() == sessionUser.getId()) {
                        isOwner = true;
                    }
                }
            }
        }
    }
}
