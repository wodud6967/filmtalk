package shop.mtcoding.filmtalk.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.reservation.ReservationRepository;
import shop.mtcoding.filmtalk.reservation.ReservationService;
import shop.mtcoding.filmtalk.ticket.Ticket;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    @Test
    public void testFindTicketsByReservationId() {

        System.out.println("---------------------------------------");
        // given
        Long reservationId = 1L;

        // when
        List<Ticket> tickets = ticketRepository.findByReservationId(reservationId);

        // then
        assertNotNull(tickets);
        assertFalse(tickets.isEmpty());
        assertEquals(2, tickets.size()); // -> reservationId 1에 티켓 2개가 있다고 가정
        System.out.println("---------------------------------------");
    }



    @Test
    public void testInsertPayment() {
        // Given : 결제 정보 생성
        Payment payment = Payment.builder()
                .type("card")
                .price(100.0)
                .payDate(Timestamp.valueOf(LocalDateTime.now()))
                .state(2)
                .impUid("imp_28446715")
                .build();

        // When : 결제 정보 저장
        Payment savedPayment = paymentRepository.save(payment);

        // Then : 저장한 데이터가 정상적으로 저장됐는지 확인
        assertNotNull(savedPayment.getId());
        assertEquals("card", savedPayment.getType());
    }

}
