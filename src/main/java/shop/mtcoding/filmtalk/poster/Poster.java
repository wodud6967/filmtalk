package shop.mtcoding.filmtalk.poster;

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
@Table(name = "poster_tb")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Builder
    public Poster(String url, Movie movie) {
        this.url = url;
        this.movie = movie;
    }
}