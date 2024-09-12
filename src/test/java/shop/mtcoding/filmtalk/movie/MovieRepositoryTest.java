package shop.mtcoding.filmtalk.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.comment.Comment;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.still.Still;

import java.util.List;


@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void findAll_test() {
        List<Movie> movies = movieRepository.mFindAllWithPosterUrls();

//        Assertions.assertTrue(movies.size() == 4);
        Assertions.assertTrue(movies.get(0).getPosterUrls().size() == 2);

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
    }
}
