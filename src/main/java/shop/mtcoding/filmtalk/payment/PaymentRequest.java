package shop.mtcoding.filmtalk.payment;

import jakarta.persistence.EntityManager;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


public class PaymentRequest {

    @Data
    public static class SaveDTO {
        private Long reservationId;  // 예매 ID (결제 고유 번호) = merchant_uid
        private String impUid;    // 가맹점 ID
    }

}
