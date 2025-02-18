package shop.mtcoding.filmtalk.screen;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.seat.Seat;
import shop.mtcoding.filmtalk.showtime.Showtime;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Table(name = "screen_tb")
@NoArgsConstructor
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //fk
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    private String name;

    @OneToMany(mappedBy = "screen")
    private List<Showtime> showtimes;

    //totalseat 총 좌석수?

    @Builder
    public Screen(Long id, Cinema cinema, String name, List<Showtime> showtimes) {
        this.id = id;
        this.cinema = cinema;
        this.name = name;
        this.showtimes = showtimes;
    }
}
