package shop.mtcoding.filmtalk.seat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.screen.ScreenRepository;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.showtime.ShowtimeRepository;
import shop.mtcoding.filmtalk.user.User;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final SeatQueryRepository seatQueryRepository;
    private final ShowtimeRepository showtimeRepository;
    private final ScreenRepository screenRepository;

    public SeatResponse.DTO 좌석메인화면(long id){

        Showtime showtimePS = showtimeRepository.mFindById(id)
                .orElseThrow(() -> new Exception404("상영시간정보가 없습니다."));

        Long screenId = showtimePS.getScreen().getId();

        Screen screenPS = screenRepository.mFindAllById(screenId)
                .orElseThrow(() -> new Exception404("상영관정보가 없습니다."));

        return new SeatResponse.DTO(showtimePS,screenPS);
    }





}
