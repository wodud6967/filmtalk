package shop.mtcoding.filmtalk.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void mFindSeatByShowtimeId_test() {

        Long showtimeId = 1L;

        ticketRepository.mFindSeatByShowtimeId(showtimeId);

        System.out.println(ticketRepository.mFindSeatByShowtimeId(showtimeId).get(0).getId());
        System.out.println(ticketRepository.mFindSeatByShowtimeId(showtimeId).get(1).getId());
    }

    @Test
    public void mFindCountOfReservedSeats_test(){
        //given
        Long showtimeId = 1L;

        Integer i = ticketRepository.mFindCountOfReservedSeats(showtimeId);

        System.out.println(i);
    }

}
