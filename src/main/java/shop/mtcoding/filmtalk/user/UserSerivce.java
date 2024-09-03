package shop.mtcoding.filmtalk.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception400;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserSerivce {
    private final UserQueryRepository userQueryRepository;

    public void 회원가입(UserRequest.JoinDTO joinDTO) {
        User oldUser = userQueryRepository.findByUsername(joinDTO.getUsername());

        if (oldUser != null) {
            throw new Exception400("이미 존재하는 유저네임입니다.");
        }

        userQueryRepository.save(joinDTO.toEntity());
    }

    public User 로그인(UserRequest.LoginDTO loginDTO) {
        User user = userQueryRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        return user;

    }
}
