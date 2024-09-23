package shop.mtcoding.filmtalk.comment;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.filmtalk.core.util.Resp;
import shop.mtcoding.filmtalk.user.User;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final HttpSession session;
    private final CommentService commentService;

    @PostMapping("/api/comment")
    public ResponseEntity<?> save(@RequestBody CommentRequest.SaveDTO saveDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        CommentResponse.DTO commentDTO = commentService.코멘트쓰기(saveDTO, sessionUser);
        return ResponseEntity.ok(Resp.ok(commentDTO));

    }

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        User SessionUser = (User) session.getAttribute("sessionUser");
        commentService.코멘트삭제하기(id, SessionUser);
        return ResponseEntity.ok(Resp.ok(null));
    }
}
