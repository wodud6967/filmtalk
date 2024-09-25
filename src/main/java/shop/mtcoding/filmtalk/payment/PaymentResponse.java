package shop.mtcoding.filmtalk.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.seat.Seat;

import java.sql.Timestamp;
import java.util.List;

public class PaymentResponse {

        @Data
        @AllArgsConstructor
        public static class PaymentViewDTO {
            private Long reservationId;        // 예약 ID
            private String username;           // 유저 이름
            private String email;
            private String phone;
            private String moviePosterUrl;     // 영화 포스터 이미지
            private String movieTitle;         // 영화 제목
            private Timestamp showtime;        // 상영 시간
            private String cinemaName;         // 영화관 이름
            private String screenName;         // 상영관 이름
            private int people;
            private List<String> seatNumbers;        // 좌석 목록
            private Integer totalPrice;           // 최종 결제 금액
            private Integer price;              // 결제 금액
            // private Timestamp payDate;         // 결제 날짜


            public PaymentViewDTO(Reservation reservation) {
                this.reservationId = reservation.getId();
                this.username = reservation.getUser().getUsername();
                this.moviePosterUrl = getMoviePosterUrl();
                this.movieTitle = getMovieTitle();
                this.showtime = getShowtime();
                this.cinemaName = getCinemaName();
                this.screenName = getScreenName();
                this.people = getPeople();
                //this.seats = getSeats();
                this.totalPrice = getTotalPrice();
                this.price = getPrice();
            }

            @Data
            public static class SeatDTO {
                private Long seatId;
                private String seatNumber;

                public SeatDTO(Long seatId, String seatNumber) {
                    this.seatId = seatId;
                    this.seatNumber = seatNumber;
                }
            }



        }


}
