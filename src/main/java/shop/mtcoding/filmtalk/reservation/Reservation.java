package shop.mtcoding.filmtalk.reservation;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.payment.Payment;
import shop.mtcoding.filmtalk.seat.Seat;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.ticket.Ticket;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "reservation_tb")
@NoArgsConstructor
@Entity
public class Reservation {
    //TODO : 주석 지우기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



    @Column(nullable = false)
    private Timestamp createdAt;

    @Builder
    public Reservation(Long id, User user, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
    }
}
