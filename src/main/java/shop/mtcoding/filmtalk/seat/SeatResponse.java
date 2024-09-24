package shop.mtcoding.filmtalk.seat;


import lombok.Data;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SeatResponse {

    @Data
    public static class DTO {

        // showtime
        private String startedAt; // 시작 시간
        private String endedAt; // 끝나는 시간
        private String wholeShowTime; // 일자 + 시간
        private Integer price; // 영화 가격 ( 1좌석당, 1티켓당 )
        // movie
        private Integer runtime; // 영화 러닝타임
        private String movieNm; // 영화 pk
        private String ratingGrade; // 등급
        //poster
        private String posterUrl; // 포스터
        // screen
        private String screenNm; // 상영관 pk
        // cinema
        private String cinemaNm; // 영화관 pk
        private String cinemaImg; // 영화관 이미지
        // seat count
        private Integer totalSeats;
        private Integer remainingSeats;

        public DTO(Showtime showtimePS, Screen screenPS, Integer totalSeat, Integer reservedSeat) {

            String formatGrande = "yyyy.MM.dd(E)";
            String formatPequeno = "HH:mm";
            String formatTotal = "yyyy.MM.dd(E) HH:mm";

            //showtimePS.getStartedAt(); // 2024-09-12 14:00:00.0

            // 시작 시간 형식 변환
            this.startedAt = convertTimeStampToString(showtimePS.getStartedAt(), formatGrande);

            // 종료 시간 계산 ( 시작 시간 + runtime )
            this.endedAt = calculateEndTime(showtimePS.getStartedAt(), showtimePS.getMovie().getRuntime()); // 종료 시간 계산

            // 전체 시간 형식 변환
            this.wholeShowTime = convertTimeStampToString(showtimePS.getStartedAt(), formatTotal);



            this.price = showtimePS.getPrice();
            this.runtime = showtimePS.getMovie().getRuntime();
            this.movieNm = showtimePS.getMovie().getMovieNm();
            this.posterUrl = showtimePS.getMovie().getPosterUrls().get(0).getUrl();

            String grade = showtimePS.getMovie().getRatingGrade();

            if(grade == "전체"){
                this.ratingGrade = "전체 관람가";
            }else{
                this.ratingGrade = grade + " 관람가";
            }

            this.screenNm = screenPS.getName();
            this.cinemaNm = screenPS.getCinema().getName();
            this.cinemaImg = screenPS.getCinema().getImgName();

            // 좌석 수
            this.totalSeats = totalSeat;
            this.remainingSeats = totalSeats - reservedSeat;

        }


        // Timestamp를 지정한 format으로 변환하는 매서드
        public static String convertTimeStampToString(Timestamp timestamp, String format) {

            if(timestamp == null) return "";

            try {
                Date date = new Date();
                date.setTime(timestamp.getTime());
                //return new SimpleDateFormat(format).format(date);

                // Locale 설정으로 요일을 한국어로 출력
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREAN);
                return sdf.format(date);
            } catch (Exception e) {
                throw new Exception404("날짜 정보가 뭔가 잘못되었습니다.");
            }

        }

        // 시작 시간에 runtime을 더해 종료 시간을 계산하는 매서드
        public static String calculateEndTime(Timestamp startedAt, int runtimeMinutes){
            LocalDateTime startDateTime = startedAt.toLocalDateTime(); // TimeStamp를 LocalDateTime으로 변환
            LocalDateTime endDateTime = startDateTime.plus(runtimeMinutes, ChronoUnit.MINUTES); // runtime을 분 단위로 더함

            // HH :mm 형식으로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return endDateTime.format(formatter);

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