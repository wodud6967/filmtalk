package shop.mtcoding.filmtalk.cinema;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;
    private final CinemaQueryRepository queryRepository;
}
