package shop.mtcoding.filmtalk.showtime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.region.Region;
import shop.mtcoding.filmtalk.screen.Screen;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
    //원래는 예약 화면에 바로 id city 영화관 리스트 쫙 띄워두고 싶었는데 컨트롤러에 /resercation 리턴 /resercation/view로 해야 하는데 json만 보내려고 하니 안돼서 이 DTO 패스해야할거같음
    @Data
    public static class RegionDTO{
        //지역 pk
        private Long id;
        // 지역 이름
       // private String city;
        //시네마 이름 리스트
        List<CinemaDTO> cinemaList = new ArrayList<>();

        public RegionDTO(Region region) {
            this.id = region.getId();
           // this.city = region.getCity();
            for(Cinema cinema : region.getCinemas()){
                cinemaList.add(new CinemaDTO(cinema));
            }
        }
    }
    
    @Data
    public static class CinemaDTO{
        private Long id;
        private String name;

        public CinemaDTO(Cinema cinema) {
            this.id = cinema.getId();
            this.name = cinema.getName();
        }
    }
    @Data
    public static class ScreenDTO{
        private Long id;

        public ScreenDTO(Screen screen) {
            this.id = screen.getId();
        }
    }
    @AllArgsConstructor
    @Data
    @Builder
    public static class MovieDTO{
        private Long id;
        private String movieNm;
        private String ratingGrade;
    }
    @Data
    public static class ShowTimeDTO {
        private Long id;
        private String time;

        public ShowTimeDTO(Showtime showtime) {
            this.id = showtime.getId();
            this.time = convertTimestampToTime(showtime.getStartedAt());
        }

        private String convertTimestampToTime(Timestamp timestamp) {
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
            return timeFormatter.format(timestamp);
        }
    }
}
