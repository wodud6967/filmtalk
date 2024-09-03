package shop.mtcoding.filmtalk.showtime;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.screen.Screen;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "showtime_tb")
@NoArgsConstructor
@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;

    @Column(nullable = false)
    private Timestamp showTime; // 상영 시간

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp modifiedAt;

    @Builder
    public Showtime(Long id, Movie movie, Screen screen, Timestamp showTime, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.showTime = showTime;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
