package shop.mtcoding.filmtalk.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.poster.PosterRepository;
import shop.mtcoding.filmtalk.still.Still;
import shop.mtcoding.filmtalk.still.StillRepository;
import shop.mtcoding.filmtalk.user.User;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieQueryRepository movieQueryRepository;

    private final StillRepository stillRepository;
    private final PosterRepository posterRepository;


    public List<MovieResponse.ListDTO> 영화목록보기() {
        List<Movie> movies = movieRepository.mFindAllWithPosterUrls();
        List<MovieResponse.ListDTO> listDTO = new ArrayList<>();
        int count = 0;
        for (Movie movie : movies) {
            if (count >= 5) {
                break; // 5개 항목을 초과하면 루프 종료
            }
            listDTO.add(new MovieResponse.ListDTO(movie));
            count++;
        }
        return listDTO;
    }

    public MovieResponse.DetailDTO 영화상세보기(int id, User sessionUser) {
        Movie movie = movieRepository.mFindOneWithCommentsById(id)
                .orElseThrow(() -> new Exception404("영화가 없습니다."));
        List<Still> stills = stillRepository.mFindAllByMovie(movie);
        List<Poster> posters = posterRepository.mFindAllByMovie(movie);
        movie.setStillUrls(stills);
        movie.setPosterUrls(posters);

        return new MovieResponse.DetailDTO(movie,sessionUser);
    }
}
