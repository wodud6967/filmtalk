package shop.mtcoding.filmtalk.admin;

import lombok.Data;
import shop.mtcoding.filmtalk.movie.Movie;

import java.util.List;

@Data
public class ShowtimeRegistrationDTO {
    private Long screenId;              // 상영관 ID
    private String screeningDate;        // 상영 날짜
    private String startTime;            // 상영 시작 시간
    private int runtime;                 // 상영 시간 (영화 런타임)
    private List<MovieDTO> availableMovies; // 등록 가능한 영화 목록

    // Movie 정보를 담을 DTO
    @Data
    public static class MovieDTO {
        private Long movieId;
        private String movieName;
        private int runtime;

        public MovieDTO(Movie movie) {
            this.movieId = movie.getId();
            this.movieName = movie.getMovieNm();
            this.runtime = movie.getRuntime();
        }
    }
}
