package shop.mtcoding.filmtalk.comment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;


@Getter
@Setter
@Table(name = "comment_tb")
@NoArgsConstructor
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Comment(Long id, String content, Timestamp createdAt, Movie movie, User user) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.movie = movie;
        this.user = user;
    }
}

