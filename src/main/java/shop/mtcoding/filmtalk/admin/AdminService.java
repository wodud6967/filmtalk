package shop.mtcoding.filmtalk.admin;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.KorDataRepository;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.still.Still;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminQueryRepository adminQueryRepository;
    private final KorDataRepository korDataRepository;
    private final MovieRepository movieRepository;

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

    public List<AdminResponse.OwnedMovieDTO> 보유중인영화리스트보여주기() {
        List<Movie> all = movieRepository.findAll();
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
}
