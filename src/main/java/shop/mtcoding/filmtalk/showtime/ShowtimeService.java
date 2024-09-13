package shop.mtcoding.filmtalk.showtime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeQueryRepository showtimeQueryRepository;



}
