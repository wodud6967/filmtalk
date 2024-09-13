package shop.mtcoding.filmtalk.seat;


import lombok.Data;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;

public class SeatResponse {

    @Data
    public static class DTO {

        // showtime
        private Timestamp startedAt;
        private Integer price;
        // movie
        private Integer runtime;
        private String movieNm;
        private String ratingGrade;
        // screen
        private String screenNm;
        // cinema
        private String cinemaNm;
        private String cinemaImg;

        public DTO(Showtime showtimePS, Screen screenPS) {

            this.startedAt = showtimePS.getStartedAt();
            this.price = showtimePS.getPrice();
            this.runtime = showtimePS.getMovie().getRuntime();
            this.movieNm = showtimePS.getMovie().getMovieNm();
            this.ratingGrade = showtimePS.getMovie().getRatingGrade();
            this.screenNm = screenPS.getName();
            this.cinemaNm = screenPS.getCinema().getName();
            this.cinemaImg = screenPS.getCinema().getImgName();

        }
    }
}
