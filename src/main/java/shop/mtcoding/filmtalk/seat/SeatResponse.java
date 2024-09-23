package shop.mtcoding.filmtalk.seat;


import lombok.Data;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Data
    public static class SeatDTO {
        private Integer totalColumn;
        private Integer totalRow;
        private List<SeatInfo> seats; // 좌석 정보를 담은 리스트
        private List<ReservedSeatInfo> reservedSeats; // 예약된 좌석들 리스트
        
        public SeatDTO(List<SeatResponse. SeatDTO. SeatInfo> seatInfos, Seat[][] seatArray, List<Seat> reservedSeatPS) {
            this.totalColumn = seatArray[0].length;
            this.totalRow = seatArray.length;

            this.seats = new ArrayList<>();
            this.reservedSeats = new ArrayList<>();

            for (int i = 0; i < seatArray.length; i++) {
                for (int j = 0; j < seatArray[i].length; j++) {
                    if (seatArray[i][j] != null) {
                        Seat seat = seatArray[i][j];
                        seats.add(new SeatInfo(seat.getId(), seat.getRowNum(), seat.getColNum()));
                        if (reservedSeatPS != null && reservedSeatPS.contains(seat)) {
                            reservedSeats.add(new ReservedSeatInfo(seat.getId(), seat.getRowNum(), seat.getColNum()));
                        }

                        //seats.add(new SeatInfo(seat.getRowNum(), seat.getColNum(), seat.isAvailable())); // 예: 좌석의 가용 여부를 포함
                    }
                }
            }

        }

        @Data
        public static class SeatInfo {
            private Long id;
            private Character row;
            private Character col;


            public SeatInfo(Long id, Character row, Character col){
                this.id = id;
                this.row = row;
                this.col = col;


            }
//            private boolean isAvailable; // 좌석의 가용 여부
//
//            public SeatInfo(Character row, Character col, boolean isAvailable) {
//                this.row = row;
//                this.col = col;
//                this.isAvailable = isAvailable;
//            }
        }

        @Data
        public static class ReservedSeatInfo {
            private Long id;
            private Character row;
            private Character col;
            private Boolean isReserved;

            public ReservedSeatInfo(Long id, Character row, Character col){
                this.id = id;
                this.row = row;
                this.col = col;
                this.isReserved = true;

            }
        }


    }
}
