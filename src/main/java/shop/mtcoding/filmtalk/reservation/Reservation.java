package shop.mtcoding.filmtalk.reservation;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.seat.Seat;
import shop.mtcoding.filmtalk.showtime.Showtime;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "reservation_tb")
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Showtime showtime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private boolean reserved;

    @Column(nullable = false)
    private Timestamp bookingTime;

    @Builder
    public Reservation(Long id, Showtime showtime, Seat seat, User user, boolean reserved, Timestamp bookingTime) {
        this.id = id;
        this.showtime = showtime;
        this.seat = seat;
        this.user = user;
        this.reserved = reserved;
        this.bookingTime = bookingTime;
    }
}
