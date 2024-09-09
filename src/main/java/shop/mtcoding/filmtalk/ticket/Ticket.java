package shop.mtcoding.filmtalk.ticket;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.reservation.Reservation;
import shop.mtcoding.filmtalk.seat.Seat;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "ticket_tb")
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    private Showtime showtime; //영화는 상영시간안에 있다.

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation; //결제를 찾을 수있음

    @Column(nullable = false)
    private Timestamp createdAt;


}
