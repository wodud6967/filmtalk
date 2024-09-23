package shop.mtcoding.filmtalk.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.user.User;

@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void 코멘트쓰기_test(){
        User user = User.builder()
                        .id(1L)
                        .username("ssar")
                        .build();

        Movie moviePS =movieRepository.findById(1L).orElseThrow(() -> new ExceptionApi404("없다"));
        CommentRequest.SaveDTO saveDTO = new CommentRequest.SaveDTO();
        saveDTO.setMovieId(5L);
        saveDTO.setComment("가나다라마바사");

        commentRepository.save(saveDTO.toEntity(user,moviePS));

        Assertions.assertEquals(11, commentRepository.findAll().size());
        
    }

    @Test
    public void 코멘트삭제하기_test(){
        Long commentId = 1L;
        User user = User.builder()
                        .id(1L)
                        .username("ssar")
                        .build();

        commentService.코멘트삭제하기(commentId, user);

        Assertions.assertTrue(commentRepository.findById(commentId).isEmpty());

    }
}
