package shop.mtcoding.filmtalk.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.user.User;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieQueryRepository movieQueryRepository;


    public List<MovieResponse.ListDTO> 영화목록보기() {
        List<Movie> movies = movieRepository.mFindAllWithPosterUrls();
        List<MovieResponse.ListDTO> listDTO = new ArrayList<>();
        for (Movie movie : movies) {
            listDTO.add(new MovieResponse.ListDTO(movie));
        }
        return listDTO;
    }

    public MovieResponse.DetailDTO 영화상세보기(int id, User sessionUser) {
//        Movie movie = movieRepository.mFindByIdWithAll(id)
//                .orElseThrow(() -> new Exception404("영화가 없습니다."));
        Movie movie = movieRepository.findById(Long.valueOf(id)).orElseThrow(()->new Exception404("Movie not found"));


        return new MovieResponse.DetailDTO(movie,sessionUser);
    }
}
