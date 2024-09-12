package shop.mtcoding.filmtalk.showtime;

import lombok.Data;

public class ShowtimeResponse {

    @Data
    public static class DTO{
        //지역
        private String city;
        //영화관
        private String cName;
        //상영관
        private String sNum;
        //상영시작시간

        //상영일

        //영화이름
        private String movieNm;
        //영화 시청등급
        private String ratingGrade;


    }
}
