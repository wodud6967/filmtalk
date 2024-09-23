package shop.mtcoding.filmtalk.showtime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.cinema.CinemaRepository;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.region.Region;
import shop.mtcoding.filmtalk.region.RegionRepository;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeQueryRepository showtimeQueryRepository;
    private final RegionRepository regionRepository;
    private final CinemaRepository cinemaRepository;
    private final ScreenRepository screenRepository;

    public ShowtimeResponse.RegionDTO 지역영화관보기(Long id) {
        Region regionPs = regionRepository.mfindByIdWithCinemas(id)
                .orElseThrow(() -> new Exception404("없습니다"));
        return new ShowtimeResponse.RegionDTO(regionPs);
    }

    public List<ShowtimeResponse.MovieDTO> 영화관영화보기(Long id){
        List<Screen> screens = screenRepository.mFindScreenByCinemaId(id);
        List<Long> screenIds = screens.stream().map(screen -> screen.getId()).toList();
        List<Showtime> showtimes = showtimeRepository.mFindByWithMovieScreenIds(screenIds);

        List<Movie> moviePs =  showtimes.stream().map(showtime -> showtime.getMovie()).distinct().toList();
        List<ShowtimeResponse.MovieDTO> movieList = new ArrayList<>();
        for(Movie movie : moviePs){
            ShowtimeResponse.MovieDTO dto = ShowtimeResponse.MovieDTO.builder()
                    .id(movie.getId())
                    .movieNm(movie.getMovieNm())
                    .ratingGrade(movie.getRatingGrade())
                    .build();
            movieList.add(dto);
        }
        return movieList;

    }
    public List<ShowtimeResponse.ShowTimeDTO> 날짜보기(Long date,Long id){
        List<Showtime> dats = showtimeRepository.mFindByDateIdMovieId(date,id);
        List<ShowtimeResponse.ShowTimeDTO> dtos = new ArrayList<>();

        for(Showtime showtime : dats){
            ShowtimeResponse.ShowTimeDTO dto = new ShowtimeResponse.ShowTimeDTO(showtime);
            dtos.add(dto);
        }
        return dtos;
    }

}
