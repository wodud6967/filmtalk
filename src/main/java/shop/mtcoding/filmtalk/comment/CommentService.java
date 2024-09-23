package shop.mtcoding.filmtalk.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi403;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.movie.MovieRepository;
import shop.mtcoding.filmtalk.user.User;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentQueryRepository commentQueryRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public void 코멘트삭제하기(Long id, User sessionUser) {
        Comment commentPS = commentRepository.findById(id).orElseThrow(() -> new ExceptionApi404("해당 코멘트를 찾을수 없습니다."));
        if (commentPS.getUser().getId() != sessionUser.getId()) {
                throw new ExceptionApi403("코멘트 삭제 권한이 없습니다.");
        }
        commentRepository.deleteById(id);
    }

    @Transactional
    public CommentResponse.DTO 코멘트쓰기(CommentRequest.SaveDTO saveDTO, User sessionUser) {
        Movie moviePS = movieRepository.findById(saveDTO.getMovieId()).orElseThrow(() ->
                new ExceptionApi404("영화를 찾을 수 없습니다."));
        Comment comment = saveDTO.toEntity(sessionUser, moviePS);
        commentRepository.save(comment);
        return new CommentResponse.DTO(comment);

    }
}
