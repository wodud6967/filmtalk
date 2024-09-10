package shop.mtcoding.filmtalk.qna;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import shop.mtcoding.filmtalk.admin.Admin;
import shop.mtcoding.filmtalk.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "qna_tb")
@NoArgsConstructor
@Entity
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String title;

    private String content;

    private Timestamp createdAt;

    private Boolean state;

    private Timestamp answeredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Qna(Long id, String type, String title, String content, Timestamp createdAt, Boolean state, Timestamp answeredAt, Admin admin, User user) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.state = state;
        this.answeredAt = answeredAt;
        this.admin = admin;
        this.user = user;
    }


}
