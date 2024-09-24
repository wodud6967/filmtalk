package shop.mtcoding.filmtalk.payment;

import jakarta.persistence.EntityManager;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


public class PaymentRequest {

    @Data
    public static class SaveDTO {
        private Long reservationId;  // 예매 ID  = merchant_uid
        private String impUid;    // 결제 대행 서비스 고유 ID
        private double price;
        private Integer state;
    }

}
