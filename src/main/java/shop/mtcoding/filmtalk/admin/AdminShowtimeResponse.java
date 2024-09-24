package shop.mtcoding.filmtalk.admin;

import lombok.Data;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.showtime.Showtime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Data
public class AdminShowtimeResponse {
    @Data
    public static class CinemaScheduleWithMoviesDTO {
        private CinemaWithScreensDTO cinemaSchedule;  // 상영관 스케줄 정보
        private List<movieDTO> movieList;  // 영화 목록

        public CinemaScheduleWithMoviesDTO(CinemaWithScreensDTO cinemaSchedule, List<movieDTO> movieList) {
            this.cinemaSchedule = cinemaSchedule;
            this.movieList = movieList;
        }
    }

    @Data
    public static class movieDTO {
        private Long movieId;
        private String movieName;
        private Integer runtime;


        public movieDTO(Movie movie) {
            this.movieId = movie.getId();
            this.movieName = movie.getMovieNm();
            this.runtime = movie.getRuntime();

        }
    }

    @Data
    public static class CinemaWithScreensDTO {
        private Long cinemaId;
        private String cinemaName;
        private List<ScreenDTO> screens = new ArrayList<>();  // ScreenDTO 리스트로 변경

        public CinemaWithScreensDTO(Cinema cinema) {
            this.cinemaId = cinema.getId();
            this.cinemaName = cinema.getName();
        }

        // ScreenDTO를 리스트에 추가하는 메서드
        public void addScreen(ScreenDTO screenDTO) {
            this.screens.add(screenDTO);
        }
    }

    @Data
    public static class ScreenDTO {
        private Long screenId;
        private String screenName;
        private List<ShowtimeDTO> showtimes = new ArrayList<>();  // 상영시간이 없어도 빈 리스트로 초기화
        private LocalDateTime  nextAvailableTime;
        private boolean canAddShowtime;

        // 상영시간 최대 개수
        private static final int MAX_SHOWTIMES = 8;

        public ScreenDTO(Screen screen, LocalDate selectedDate) {
            this.screenId = screen.getId();
            this.screenName = screen.getName();
            this.nextAvailableTime = LocalDateTime.of(selectedDate, LocalTime.of(12, 0));  // 날짜와 시간을 결합해서 초기화
            this.canAddShowtime = true;
        }

        // ShowtimeDTO를 추가하는 메서드
        public void addShowtime(ShowtimeDTO showtimeDTO) {
            this.showtimes.add(showtimeDTO);
        }

        public void calculateNextAvailableTime(LocalDate selectedDate) {
            if (showtimes.isEmpty()) {
                // 상영 시간이 없을 경우, 해당 날짜의 12:00을 기본값으로 설정
                this.nextAvailableTime = LocalDateTime.of(selectedDate, LocalTime.of(12, 0));
            } else {
                ShowtimeDTO lastShowtime = showtimes.get(showtimes.size() - 1);

                try {
                    // 마지막 상영 시간 종료 시간을 계산
                    LocalTime lastStartTime = LocalTime.parse(lastShowtime.getStartedAt());
                    LocalDateTime lastEndTime = LocalDateTime.of(selectedDate, lastStartTime)
                            .plusMinutes(lastShowtime.getRuntime());

                    // 종료 시간에 30분을 더해 다음 상영 가능 시간 계산
                    this.nextAvailableTime = lastEndTime.plusMinutes(30);
                } catch (Exception e) {
                    // 오류 발생 시 기본값 설정
                    this.nextAvailableTime = LocalDateTime.of(selectedDate, LocalTime.of(12, 0));
                }
            }

            // 상영 시간 추가 가능 여부 확인
            this.canAddShowtime = this.showtimes.size() < MAX_SHOWTIMES;
        }

        // 다음 상영 시간을 String으로 포맷팅하여 반환하는 메서드
        public String getFormattedNextAvailableTime() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return this.nextAvailableTime.format(formatter);  // "YYYY-MM-DD HH:mm" 형식으로 반환
        }
    }

    @Data
    public static class ShowtimeDTO {
        private Long showtimeId;
        private String movieName;
        private Integer runtime;
        private String startedAt;

        public ShowtimeDTO(Showtime showtime) {
            this.showtimeId = showtime.getId();
            this.movieName = showtime.getMovie().getMovieNm();
            this.runtime = showtime.getMovie().getRuntime();
            this.startedAt = new SimpleDateFormat("HH:mm").format(showtime.getStartedAt());
        }
    }
}
