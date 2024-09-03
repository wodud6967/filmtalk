package shop.mtcoding.filmtalk.screen;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ScreenService {
    private final ScreenQueryRepository screenQueryRepository;
    private final ScreenRepository screenRepository;
}
