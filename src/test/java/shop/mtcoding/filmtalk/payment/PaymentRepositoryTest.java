package shop.mtcoding.filmtalk.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

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

    @Test
    public void testUpdatePayment() {
        // Given : 결제 정보 DTO 준비
        PaymentRequest.SaveDTO saveDTO = new PaymentRequest.SaveDTO();
        saveDTO.setReservationId("1");
        saveDTO.setImpUid("imp_28446715");

        // When : 결제 정보 저장 로직 호출
        paymentService.save(saveDTO);

        // Then : 추가적으로 저장된 데이터를 조회해도 됨
    }
}
