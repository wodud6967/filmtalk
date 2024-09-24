package shop.mtcoding.filmtalk.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.filmtalk.seat.Seat;

import java.util.List;

@DataJpaTest
public class TicketRepositoryTest {

    @Autowired
    private TicketRepsoitory ticketRepsoitory;

    @Test
    public void mFindSeatByShowtimeId_test() {

        Long showtimeId = 1L;

        ticketRepsoitory.mFindSeatByShowtimeId(showtimeId);

        System.out.println(ticketRepsoitory.mFindSeatByShowtimeId(showtimeId).get(0).getId());
        System.out.println(ticketRepsoitory.mFindSeatByShowtimeId(showtimeId).get(1).getId());
    }

    @Test
    public void mFindCountOfReservedSeats_test(){
        //given
        Long showtimeId = 1L;

        Integer i = ticketRepsoitory.mFindCountOfReservedSeats(showtimeId);

        System.out.println(i);
    }

}
