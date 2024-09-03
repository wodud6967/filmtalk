package shop.mtcoding.filmtalk.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;
}
