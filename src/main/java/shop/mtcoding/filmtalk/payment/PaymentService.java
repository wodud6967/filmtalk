package shop.mtcoding.filmtalk.payment;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi404;
import shop.mtcoding.filmtalk.core.error.ex.ExceptionApi500;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.reservation.ReservationRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentQueryRepository paymentQueryRepository;
    private final IamportClient iamportClient;
    private final ReservationRepository reservationRepository;

    @Transactional
    public void save(PaymentRequest.SaveDTO saveDTO) {

        try {
            // 클라이언트가 결제 됐다고 알림 -> SaveDTO로 / 예매ID(reservationId), 가맹점ID(impUid)
            IamportResponse<com.siot.IamportRestClient.response.Payment> iamportResponse = iamportClient.paymentByImpUid(saveDTO.getImpUid());

            // 결제 완료가 아니면
            if(!iamportResponse.getResponse().getStatus().equals("paid")) {
                // 티켓도 2장 삭제

                // 주문&결제 삭제 (예매=부모 삭제하면, 티켓도 삭제 되는지 확인)
                // TODO: 테스트 후 39라인 주석 해제
                // reservationRepository.deleteById(saveDTO.getReservationId());
                Long reservationId = Long.parseLong(saveDTO.getReservationId());
                reservationRepository.deleteById(reservationId);


                throw new ExceptionApi500("결제 미완료");
            }

            // Payment Insert
            //Reservation reservationPS = reservationRepository.findById(saveDTO.getReservationId())
            Reservation reservationPS = reservationRepository.findById(1L) // TODO: 결제 테스트 후 변경 예정
                    .orElseThrow(() -> new ExceptionApi404("예매 내역이 존재하지 않아서 결제할 수 없습니다"));
            Payment payment = Payment.builder()
                    .price(100.0)
                    .point(0)
                    .state(2) // 결제 완료
                    .cnclDate(null)
                    .payDate(Timestamp.valueOf(LocalDateTime.now()))
                    .impUid(saveDTO.getImpUid())
                    .type("card")
                    .mycoupon(null)
                    .reservation(reservationPS)
                    .build();
            paymentRepository.save(payment);

        } catch (Exception e) {
            throw new ExceptionApi500(e.getMessage());
        }
    }
}
