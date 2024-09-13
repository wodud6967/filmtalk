package shop.mtcoding.filmtalk.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
<<<<<<< HEAD
import shop.mtcoding.filmtalk.comment.Comment;
=======
>>>>>>> 299b12f (영화 메인, 상세보기 페이지 구현 완료)
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.poster.PosterRepository;
import shop.mtcoding.filmtalk.still.Still;
<<<<<<< HEAD
=======
import shop.mtcoding.filmtalk.still.StillRepository;
>>>>>>> 299b12f (영화 메인, 상세보기 페이지 구현 완료)

import java.util.List;


@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    StillRepository stillRepository;

    @Autowired
    PosterRepository posterRepository;

    @Test
    public void makeMovieWithAll(){
        int id = 1;
        Movie movie = movieRepository.mFindByIdWithComments(id).orElseThrow(() -> new Exception404("없다이놈아"));
        List<Still> stills = stillRepository.mFindAllByMovie(movie);
        List<Poster> posters = posterRepository.mFindAllByMovie(movie);
        System.out.println("=====================no more hiber ---------------");
        movie.setStillUrls(stills);
        movie.setPosterUrls(posters);
        Assertions.assertTrue(movie.getStillUrls().size() ==9 && movie.getPosterUrls().size() ==2);

    }

    @Test
    public void findStillsByMovie(){
        int id = 1;
        Movie movie = movieRepository.mFindByIdWithComments(id).orElseThrow(() -> new Exception404("없다이놈아"));
        List<Still> allByMovie = stillRepository.mFindAllByMovie(movie);
        Assertions.assertTrue(allByMovie.size() == 9);


    }
    @Test
    public void findPostersByMovie(){
        int id = 1;
        Movie movie = movieRepository.mFindByIdWithComments(id).orElseThrow(() -> new Exception404("없다이놈아"));
        List<Poster> allByMovie = posterRepository.mFindAllByMovie(movie);
        Assertions.assertTrue(allByMovie.size()==2);


    }

    @Test
    public void findAll_test() {
        List<Movie> movies = movieRepository.mFindAllWithPosterUrls();
        Assertions.assertTrue(movies.get(0).getPosterUrls().size() == 2);
<<<<<<< HEAD

    }

    @Test
    public void mFindByIdWithAll_test() {
        int id = 1;
        Movie movie = movieRepository.mFindOneWithCommentsById(id).orElseThrow(() -> new Exception404("없는영화다"));
        System.out.println("----------------------------");

        System.out.println(movie.toString());

        System.out.println("----------영화 다운 완료------------");

        System.out.println("----------포스터 읽기 시작------------");
        List<Poster> posterUrls = movie.getPosterUrls();
        for (Poster poster : posterUrls) {
            System.out.println(poster.getUrl());
        }
        System.out.println("----------포스터 읽기 완료------------");
        System.out.println("----------스틸 읽기 시작------------");
        List<Still> stillUrls = movie.getStillUrls();
        for (Still still : stillUrls) {
            System.out.println(still.getUrl());
        }
        System.out.println("----------스틸 읽기 완료------------");
        System.out.println("----------코멘트 읽기 시작------------");
        List<Comment> comments = movie.getComments();
        for (Comment comment : comments) {
            System.out.println(comment.getContent());
        }
        System.out.println("----------코멘트 읽기 완료------------");
        System.out.println("----------코멘트 안 유저 읽기 시작------------");

        for (Comment comment : comments) {
            System.out.println(comment.getUser().getUsername());
        }

        System.out.println("----------코멘트 안 유저 읽기 완료------------");
=======
>>>>>>> 299b12f (영화 메인, 상세보기 페이지 구현 완료)
    }
}
