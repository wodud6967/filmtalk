package shop.mtcoding.filmtalk.admin;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.KorDataRepository;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
//        Set<String> registMovieNames = registMovie.stream()
//                .map(Movie::getMovieNm) // Movie의 이름 필드
//                .collect(Collectors.toSet());
//        rawMovie.stream()
//                .filter(a -> !registMovieNames.contains(a.getMovieNm())) // 영화명이 registMovieNames에 없을 때만 필터링
//                .collect(Collectors.toList());
        List<AdminResponse.MovieDTO> movieDTOS = new ArrayList<>();
        for (NeedData needData : rawMovie) {
            movieDTOS.add(new AdminResponse.MovieDTO(needData));
        }

        return movieDTOS;
    }

    public AdminResponse.MovieDTO API영화상세보기(String movieNm) {
        NeedData Movie = null;
        for (NeedData needData : rawMovie) {
            if (needData.getMovieNm().equals(movieNm)) {
                Movie = needData;
            }
        }
        return new AdminResponse.MovieDTO(Movie);
    }

    @Transactional
    public void 영화등록하기(AdminRequest.SaveMovieDTO saveMovieDTO) {
        Movie movieEntity = saveMovieDTO.toEntity();
        movieRepository.save(movieEntity);

    }
}
