package shop.mtcoding.filmtalk.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final AdminService adminService;
}
