package shop.mtcoding.filmtalk.admin;

import jakarta.servlet.http.PushBuilder;
import jakarta.transaction.Transactional;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import retrofit2.http.PUT;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.cinema.CinemaRepository;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenQueryRepository;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.user.User;
import shop.mtcoding.filmtalk.user.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;
    @MockBean
    private AdminService adminService;  //


    @Test
    public void findScreensWithShowtimesByIdsAndDate_test3() {
        Long cinemaId = 1L;

        // 영화관 정보를 가져옴
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new IllegalArgumentException("Cinema not found"));

        // CinemaWithScreensDTO에 영화관 정보를 저장
        AdminResponse.CinemaWithScreensDTO cinemaWithScreensDTO = new AdminResponse.CinemaWithScreensDTO(cinema);

        System.out.println("--------------");
        // 상영관들의 ID 리스트를 추출
        List<Long> screenIds = cinema.getScreens()
                .stream()
                .map(Screen::getId)
                .collect(Collectors.toList());
        LocalDate date12 = LocalDate.of(2024, 9, 12);
        // 각 상영관에 대한 ScreenDTO 생성
        for (Screen screen : cinema.getScreens()) {
            AdminResponse.ScreenDTO screenDTO = new AdminResponse.ScreenDTO(screen,date12 );
            cinemaWithScreensDTO.addScreen(screenDTO);  // 각 상영관 정보를 추가
        }
        System.out.println("22222222222222");

        // 2024년 9월 12일로 설정


        // 상영관 ID 리스트와 9월 12일에 해당하는 상영시간을 조회
        List<Showtime> showtimes = showtimeRepository.findByScreenIdsAndShowDate(screenIds, date12);

        // 상영시간을 각 상영관에 추가
        for (Showtime showtime : showtimes) {
            AdminResponse.ShowtimeDTO showtimeDTO = new AdminResponse.ShowtimeDTO(showtime);

            // 해당 상영관을 찾아서 showtime을 추가
            cinemaWithScreensDTO.getScreens().stream()
                    .filter(screenDTO -> screenDTO.getScreenId().equals(showtime.getScreen().getId()))
                    .findFirst()
                    .ifPresent(screenDTO -> screenDTO.addShowtime(showtimeDTO));
        }

        // 영화관 및 상영관 정보 출력
        System.out.println("영화관 이름: " + cinemaWithScreensDTO.getCinemaName());
        for (AdminResponse.ScreenDTO screenDTO : cinemaWithScreensDTO.getScreens()) {
            System.out.println("상영관 이름: " + screenDTO.getScreenName());
            for (AdminResponse.ShowtimeDTO showtimeDTO : screenDTO.getShowtimes()) {
                System.out.println("  영화 이름: " + showtimeDTO.getMovieName());
                System.out.println("  상영 시간: " + showtimeDTO.getStartedAt());
            }
        }
    }


    @Test
    public void findScreensWithShowtimesByIdsAndDate_test2() {
        // 1. 사전 데이터 준비
        Long cinemaId = 1L;
        Cinema cinemas = cinemaRepository.mFindByIdWithScreen(cinemaId); // Cinema 엔티티와 그 하위 Screen 목록을 로드
        List<Long> screenIds = new ArrayList<>();
        cinemas.getScreens().forEach(screen -> screenIds.add(screen.getId())); // Screen의 ID 목록을 추출

        LocalDate date12 = LocalDate.of(2024, 9, 12); // 2024년 9월 12일
        LocalDate date13 = LocalDate.of(2024, 9, 13); // 2024년 9월 13일

        // 2. 테스트 대상 로직 실행
        List<Object[]> resultForDate12 = screenRepository.findScreensWithShowtimesByIdsAndDate2(screenIds, "2024-09-12");
        List<Object[]> resultForDate13 = screenRepository.findScreensWithShowtimesByIdsAndDate2(screenIds, "2024-09-13");

        // 3. 결과 검증
        System.out.println("12일 결과:");
        resultForDate12.forEach(row -> {
            System.out.println("Screen ID: " + row[0] + ", Screen Name: " + row[1]);
            System.out.println("Started At: " + row[2] + ", Movie ID: " + row[3]);
        });

        System.out.println("13일 결과:");
        resultForDate13.forEach(row -> {
            System.out.println("Screen ID: " + row[0] + ", Screen Name: " + row[1]);
            System.out.println("Started At: " + row[2] + ", Movie ID: " + row[3]);
        });


    }


    @Test
    public void findScreensWithShowtimesByIdsAndDate_test(){
        Long cinemaId = 1L;
        Cinema cinemas = cinemaRepository.mFindByIdWithScreen(cinemaId);
        List<Long> screenIds = new ArrayList<>();;
        for (Screen screen : cinemas.getScreens()) {
            screenIds.add(screen.getId());
            System.out.println(screen.getId());

        }
        ;
        LocalDate date12 = LocalDate.of(2024, 9, 12); // 2024년 9월 12일
        LocalDate date13 = LocalDate.of(2024, 9, 13); // 2024년 9월 13일

        List<Screen> screens1 =screenRepository.findScreensWithShowtimesByIdsAndDate(screenIds,date12);
        System.out.println("--------------------");
        System.out.println("12일");
        for (Screen screen : screens1) {
            System.out.println(screen.getName());

            for (Showtime showtime : screen.getShowtimes()){
                System.out.println(showtime.getStartedAt());
            }
        }

        System.out.println("33333333333333333333");
        System.out.println("13일");
        List<Screen> screens2 =screenRepository.findScreensWithShowtimesByIdsAndDate(screenIds,date13);
        for (Screen screen : screens2) {
            System.out.println(screen.getName());
            for (Showtime showtime : screen.getShowtimes()){
                System.out.println(showtime.getStartedAt());
            }
        }

    }

    @Test
    public void mFindOneByScreenIdOrderByStartedAtDesc(){
        Long screenId = 1L;
        List<Showtime> showtimes = showtimeRepository.mFindOneByScreenIdOrderByStartedAtDesc(screenId);

        for (Showtime showtime : showtimes) {
            System.out.println(showtime.getId());
            System.out.println(showtime.getStartedAt());
        }
    }


    @Test
    public void admin_mFindAllwithScreenByIds(){
        Long cinemaId = 1L;
        Cinema cinemas = cinemaRepository.mFindByIdWithScreen(cinemaId);
        List<Long> screenIds = new ArrayList<>();;
        for (Screen screen : cinemas.getScreens()) {
            screenIds.add(screen.getId());

        }
        for (Long screenId : screenIds) {
            System.out.println("상영관id = " + screenId);
        }

        // 저장된 상영관 ID들을 통해 상영관과 그에 속한 showtime을 조회
        List<Screen> screensWithShowtimes = screenRepository.findScreensWithShowtimesByIds(screenIds);

        // 결과 출력 (테스트용)
        for (Screen screen : screensWithShowtimes) {
            System.out.println("상영관 id = " + screen.getId());
            for (Showtime showtime : screen.getShowtimes()) {
                System.out.println("상영시간 = " + showtime.getMovie().getRuntime());
            }
        }
    }

    @Test
    public  void mFindAllWithScreen(){
     List<Cinema> cinemas = cinemaRepository.mFindAllWithScreen();
     for (Cinema cinema : cinemas) {
         System.out.println(cinema.getName());
            List<Screen> screens =  cinema.getScreens();
                 for (Screen screen : screens) {

                     System.out.println(screen.getName());

                 }
     }

    }

    @Test
    public void mFindByOneUsernameAndPassword_test(){
       Admin admin = adminRepository.mFindByOneUsernameAndPassword("ssar","1234").get();
        System.out.println(admin.getUsername());
        System.out.println(admin.getName());
    }

}
