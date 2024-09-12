package shop.mtcoding.filmtalk.comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.user.User;


@Getter
@Setter
@Table(name = "comment_tb")
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;
    @CreationTimestamp
    private String timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    public Comment(Long id, String content, String timestamp, Movie movie, User user) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.movie = movie;
        this.user = user;
    }
}

