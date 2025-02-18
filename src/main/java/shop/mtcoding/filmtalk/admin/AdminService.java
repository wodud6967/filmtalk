package shop.mtcoding.filmtalk.admin;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.KorDataRepository;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.cinema.CinemaRepository;
import shop.mtcoding.filmtalk.core.error.ex.Exception401;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi401;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.still.Still;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminQueryRepository adminQueryRepository;
    private final CinemaRepository cinemaRepository;
    private  final ScreenRepository screenRepository;
    private  final MovieRepository movieRepository;
    private final ShowtimeRepository showtimeRepository;
    private final KorDataRepository korDataRepository;


    public Admin 로그인(AdminShotimeRequest.LoginDTO loginDTO) {
        Admin admin  = adminRepository.mFindByOneUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword())
                .orElseThrow(() -> new Exception401("인증되지 않았습니다"));

        return admin;
    }




    private List<NeedData> rawMovie;

    public List<AdminResponse.MovieDTO> API영화리스트보여주기() {
        rawMovie = new ArrayList<>();
        rawMovie = korDataRepository.getRawMovie();
        List<Movie> registMovie = movieRepository.findAll();

        List<NeedData> toRemove = new ArrayList<>();

        for (NeedData needData : rawMovie) {
            for (Movie movie : registMovie) {
                if (needData.getMovieNm().equals(movie.getMovieNm())) {
                    toRemove.add(needData);
                    break;
                }
            }
        }
        // 원본 리스트에서 삭제
        rawMovie.removeAll(toRemove);
        List<AdminResponse.MovieDTO> movieDTOS = new ArrayList<>();
        for (NeedData needData : rawMovie) {
            movieDTOS.add(new AdminResponse.MovieDTO(needData));
        }

        return movieDTOS;
    }

    public AdminResponse.MovieDTO API영화상세보기(String movieNm) {
        NeedData movie = null;
        for (NeedData needData : rawMovie) {
            if (needData.getMovieNm().equals(movieNm)) {
                movie = needData;
            }
        }
        return new AdminResponse.MovieDTO(movie);
    }

    @Transactional
    public void 영화등록하기(AdminRequest.SaveMovieDTO saveMovieDTO) {
        Movie movieEntity = saveMovieDTO.toEntity();
        movieRepository.save(movieEntity);

    }

    public List<AdminResponse.OwnedMovieDTO> 보유중인영화리스트보여주기(String movieNm, String director, String nationNm, String company, String ratingGrade) {
        List<Movie> all;
        if (movieNm == null && director == null && nationNm == null && company == null && ratingGrade == null) {
            all = movieRepository.findAll();
        } else {
            all = movieRepository.mFindAll(movieNm, director, nationNm, company, ratingGrade);
        }

        List<AdminResponse.OwnedMovieDTO> ownedMovieDTO = new ArrayList<>();
        for (Movie movie : all) {
            ownedMovieDTO.add(new AdminResponse.OwnedMovieDTO(movie));
        }
        return ownedMovieDTO;
    }

    public AdminResponse.OwnedMovieDetailDTO 보유중인영화상세보기(int id) {
        Movie movie = movieRepository.mFindOneWithCommentsById(id).orElseThrow(() -> new Exception404("영화를 찾을 수 없습니다."));
        return new AdminResponse.OwnedMovieDetailDTO(movie);

    }

    @Transactional
    public void 보유중인영화수정하기(Long id, AdminRequest.@Valid SaveMovieDTO saveMovieDTO) {
        Movie moviebyId = movieRepository.findById(id).orElseThrow(() -> new ExceptionApi404("영화를 찾을 수 없습니다."));
        Movie movieEntity = saveMovieDTO.toEntity();
        moviebyId.setMovieNm(movieEntity.getMovieNm());
        moviebyId.setPrdtYear(movieEntity.getPrdtYear());
        moviebyId.setOpenDt(movieEntity.getOpenDt());
        moviebyId.setNationNm(movieEntity.getNationNm());
        moviebyId.setGenreNm(movieEntity.getGenreNm());
        moviebyId.setDirector(movieEntity.getDirector());
        moviebyId.setCompany(movieEntity.getCompany());
        moviebyId.setRuntime(movieEntity.getRuntime());
        moviebyId.setRatingGrade(movieEntity.getRatingGrade());
        moviebyId.setVodUrl(movieEntity.getVodUrl());
        moviebyId.setPlot(movieEntity.getPlot());
        moviebyId.setActorNm(movieEntity.getActorNm());
        moviebyId.getPosterUrls().clear();
        for (Poster poster : movieEntity.getPosterUrls()) {
            poster.setMovie(moviebyId);
            moviebyId.getPosterUrls().add(poster);
        }

        moviebyId.getStillUrls().clear();
        for (Still still : movieEntity.getStillUrls()) {
            still.setMovie(moviebyId);
            moviebyId.getStillUrls().add(still);
        }
    }

    public void 보유중인영화삭제하기(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ExceptionApi404("영화를 찾을 수 없습니다."));

        //showtime_tb 연관성으로 삭제 불가
//        movieRepository.deleteById(id);

    }

    public AdminShowtimeResponse.CinemaScheduleWithMoviesDTO 상영관별상영스케줄(Admin sessionAdmin, LocalDate selectedDate) {

        System.out.println(selectedDate);

        // 영화 목록을 가져옴
        List<Movie> movies = movieRepository.findAll();
        List<AdminShowtimeResponse.movieDTO> movieDTOList = new ArrayList<>();
        for (Movie movie : movies) {
            movieDTOList.add(new AdminShowtimeResponse.movieDTO(movie));
        }

        Long cinemaId = 1L;

        // 영화관 정보를 가져옴
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new IllegalArgumentException("Cinema not found"));

        // CinemaWithScreensDTO에 영화관 정보를 저장
        AdminShowtimeResponse.CinemaWithScreensDTO cinemaWithScreensDTO = new AdminShowtimeResponse.CinemaWithScreensDTO(cinema);

        // 상영관들의 ID 리스트를 추출
        List<Long> screenIds = new ArrayList<>();
        for (Screen screen : cinema.getScreens()) {
            screenIds.add(screen.getId());
        }

        // 각 상영관에 대한 ScreenDTO 생성
        for (Screen screen : cinema.getScreens()) {
            AdminShowtimeResponse.ScreenDTO screenDTO = new AdminShowtimeResponse.ScreenDTO(screen);
            cinemaWithScreensDTO.addScreen(screenDTO);  // 각 상영관 정보를 추가
        }

        // 상영시간을 조회 (주어진 날짜와 상영관 ID 리스트에 맞게)
        List<Showtime> showtimes = showtimeRepository.findByScreenIdsAndShowDate(screenIds, selectedDate);

        // 각 상영관에 대해 showtime 추가 및 검증
        for (AdminShowtimeResponse.ScreenDTO screenDTO : cinemaWithScreensDTO.getScreens()) {
            // 상영관에 해당하는 상영시간 필터링
            List<Showtime> screenShowtimes = new ArrayList<>();
            for (Showtime showtime : showtimes) {
                if (showtime.getScreen().getId().equals(screenDTO.getScreenId())) {
                    screenShowtimes.add(showtime);
                }
            }

            // 상영 시간이 있을 경우
            if (!screenShowtimes.isEmpty()) {
                for (Showtime showtime : screenShowtimes) {
                    AdminShowtimeResponse.ShowtimeDTO showtimeDTO = new AdminShowtimeResponse.ShowtimeDTO(showtime);
                    screenDTO.addShowtime(showtimeDTO);

                    // 마지막 상영 종료 시간을 계산 (상영 시작 시간 + 런타임 + 30분)
                    LocalDateTime showtimeEnd = showtime.getStartedAt().toLocalDateTime()
                            .plusMinutes(showtime.getMovie().getRuntime() + 30);

                    // selectedDate의 다음날 자정 기준으로 비교
                    LocalDateTime midnight = selectedDate.plusDays(1).atTime(0, 0);  // 다음날 자정

                    // 자정 기준 검증
                    if (showtimeEnd.isBefore(midnight)) {
                        screenDTO.setCanAddShowtime("true");
                        screenDTO.setNextAvailableTime(showtimeEnd);
                    } else {
                        screenDTO.setCanAddShowtime(null);
                    }
                }
            } else {
                // 상영 시간이 없을 경우
                LocalDate previousDate = selectedDate.minusDays(1);

                System.out.println("상영시간이 없을경우");
                List<Showtime> previousDayShowtimes = showtimeRepository.findByScreenIdsAndShowDate(Collections.singletonList(screenDTO.getScreenId()), previousDate);

                if (previousDayShowtimes.isEmpty()) {
                    // 전날에도 상영 시간이 없는 경우
                    screenDTO.setNextAvailableTime(selectedDate.atStartOfDay()); // 0시로 설정
                    screenDTO.setCanAddShowtime("true");
                } else {
                    // 전날 상영 시간이 있는 경우
                    Showtime lastShowtime = previousDayShowtimes.get(previousDayShowtimes.size() - 1);
                    LocalDateTime previousEndTime = lastShowtime.getStartedAt().toLocalDateTime()
                            .plusMinutes(lastShowtime.getMovie().getRuntime() + 30);

                    if (previousEndTime.isBefore(selectedDate.atStartOfDay())) {
                        screenDTO.setNextAvailableTime(selectedDate.atStartOfDay()); // 0시로 설정
                    } else {
                        screenDTO.setNextAvailableTime(previousEndTime);
                    }
                    screenDTO.setCanAddShowtime("true");
                }
            }
        }

        // 최종적으로 CinemaScheduleWithMoviesDTO 반환
        return new AdminShowtimeResponse.CinemaScheduleWithMoviesDTO(cinemaWithScreensDTO, movieDTOList);
    }

    //어드민 유저확인해야함 원래 -- 추가필요
    @Transactional
    public int 상영관등록하기(AdminShotimeRequest.ShowtimeSaveRequest req) {
        // 영화와 상영관을 가져옴
        Movie movie = movieRepository.findById(req.getMovieId())
                .orElseThrow(() -> new ExceptionApi401("Movie not found"));
        Screen screen = screenRepository.findById(req.getScreenId())
                .orElseThrow(() -> new ExceptionApi404("Screen not found"));

        // 상영 시간 엔티티 생성
        Showtime showtime = new Showtime();
        showtime.setMovie(movie);
        showtime.setScreen(screen);
        showtime.setPrice(req.getPrice());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(req.getTime(), formatter);
        // LocalDateTime을 Timestamp로 변환
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        showtime.setStartedAt(timestamp);  // 상영 시작 시간 설정

        int dayOfMonth = localDateTime.getDayOfMonth();
        // 상영 시간 저장
        showtimeRepository.save(showtime);


        return dayOfMonth;


    }


    public AdminMemberResponse 관리자리스트보여주기() {
        List<Admin> admins = adminRepository.findAll();

        // Admin 리스트를 adminDTO 리스트로 변환
        List<AdminMemberResponse.adminDTO> adminDTOs = admins.stream()
                .map(AdminMemberResponse.adminDTO::new)  // 각 Admin 객체를 adminDTO로 변환
                .collect(Collectors.toList());

        AdminMemberResponse response = new AdminMemberResponse();
        response.setAdminList(adminDTOs);  // 변환된 adminDTO 리스트를 설정

        return response;
    }

}





