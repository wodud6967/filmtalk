package shop.mtcoding.filmtalk.still;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.movie.Movie;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "still_tb")
public class Still {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Builder
    public Still(String url, Movie movie) {
        this.url = url;
        this.movie = movie;
    }
}