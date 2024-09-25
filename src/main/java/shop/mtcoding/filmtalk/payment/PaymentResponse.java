package shop.mtcoding.filmtalk.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.seat.Seat;
import shop.mtcoding.filmtalk.showtime.Showtime;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static shop.mtcoding.filmtalk.seat.SeatResponse.DTO.calculateEndTime;
import static shop.mtcoding.filmtalk.seat.SeatResponse.DTO.convertTimeStampToString;

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
            private String showtime;        // 상영 시작 시간
            private String endtime;          // 상영 종료 시간
            private String wholeShowTime;   // 전체 상영 시간 (yyyy.MM.dd HH:mm 형식)
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
                this.endtime = getEndtime();
                this.wholeShowTime = getWholeShowTime();
                this.cinemaName = getCinemaName();
                this.screenName = getScreenName();
                this.people = getPeople();
                //this.seats = getSeats();
                this.totalPrice = getTotalPrice();
                this.price = getPrice();

                // 호정씨 코드 참조 (날짜 포맷 변환)
                Showtime showtime = reservation.getTickets().get(0).getShowtime();
                this.moviePosterUrl = showtime.getMovie().getPosterUrls().get(0).getUrl();
                this.movieTitle = showtime.getMovie().getMovieNm();

                String formatTime = "HH:mm";
                String formatFull = "yyyy.MM.dd(E) HH:mm";

                // 시작 시간 포맷팅
                Timestamp startedAt = Timestamp.valueOf(showtime.getStartedAt().toLocalDateTime());
                this.showtime = convertTimeStampToString(startedAt, formatTime);  // 시작 시간 HH:mm 형식

                // 종료 시간 계산 (시작 시간 + runtime)
                int runtimeMinutes = showtime.getMovie().getRuntime();  // 영화의 런타임
                this.endtime = calculateEndTime(startedAt, runtimeMinutes);  // 종료 시간 HH:mm 형식

                // 전체 상영 시간 (yyyy.MM.dd HH:mm)
                this.wholeShowTime = convertTimeStampToString(startedAt, formatFull);

                // 상영관 및 영화관 정보
                this.cinemaName = showtime.getScreen().getCinema().getName();
                this.screenName = showtime.getScreen().getName();

                this.people = reservation.getTickets().size();  // 예매된 인원 수
                this.seatNumbers = reservation.getTickets().stream()
                        .map(ticket -> ticket.getSeat().getSeatNumber())
                        .collect(Collectors.toList());  // 좌석 목록

                this.totalPrice = reservation.getTickets().size() * showtime.getPrice();  // 총 금액 계산
                this.price = totalPrice;  // 결제 금액 (할인 적용 시 별도로 처리 가능)
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
