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
        private Screen screen; //상영관


        private Double price;



        @Column(nullable = false)
        private Timestamp startedAt;

        @Builder
        public Showtime(Long id, Movie movie, Screen screen, Timestamp startedAt) {
            this.id = id;
            this.movie = movie;
            this.screen = screen;
            this.startedAt = startedAt;
        }

        @Builder
        public Double getPrice() {
            return price;
        }
    }
