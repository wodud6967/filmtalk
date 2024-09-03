package shop.mtcoding.filmtalk.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "payment_tb")
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String type; // 신용카드 or 간편결제(카카오페이, 토스페이 등)
    @Column(nullable = false)
    private Double price; // 결제 금액

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp payDate; // 결제 일자


    private Timestamp cnclDate; // 취소 일자

    @Column(length = 40)
    private String mycoupon; // 결제 시 적용할 쿠폰

    @Column(nullable = false)
    private Integer point ; // 결제 시 적용할 포인트

    @Column(nullable = false)
    private Integer state ; // 결제 상태 (0:결제전, 1:결제완료, 2:취소)

    @Column(nullable = false, length = 40)
    private String impUid; // 결제 고유 API

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // User 엔티티와의 관계

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation; // Reservation 엔티티와의 관계

    public Payment(Long id, String type, Double price, Timestamp payDate, Timestamp cnclDate, String mycoupon, Integer point, Integer state, String impUid, User user, Reservation reservation) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.payDate = payDate;
        this.cnclDate = cnclDate;
        this.mycoupon = mycoupon;
        this.point = point;
        this.state = state;
        this.impUid = impUid;
        this.user = user;
        this.reservation = reservation;
    }
}
