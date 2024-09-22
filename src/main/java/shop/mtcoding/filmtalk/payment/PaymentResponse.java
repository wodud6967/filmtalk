package shop.mtcoding.filmtalk.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

public class PaymentResponse {

        @Data
        @AllArgsConstructor
        public static class PaymentViewDTO {
            private Long reservationId;        // 예약 ID
            private String username;           // 유저 이름
            private String moviePosterUrl;     // 영화 포스터 이미지
            private String movieTitle;         // 영화 제목
            private Timestamp showtime;        // 상영 시간
            private String screenName;         // 상영관 이름
            private String cinemaName;         // 영화관 이름
            private int people;
            private List<String> seats;        // 좌석 목록
            private Double payPrice;           // 최종 결제 금액
            private Double price;              // 결제 금액
            // private Timestamp payDate;         // 결제 날짜

        }

}
