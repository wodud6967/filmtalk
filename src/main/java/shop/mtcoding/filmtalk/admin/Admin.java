package shop.mtcoding.filmtalk.admin;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.filmtalk.cinema.Cinema;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "admin_tb")
@NoArgsConstructor
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(nullable = false)
    private String name;  // 실제 이름 추가

    private String role; // ROLE_ADMIN, ROLE_SUPERADMIN 등

    @Column(nullable = false)
    private Boolean approved = false; // 승인 여부 추가


    private String profileUrl; // 프로필 사진 URL 추가

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @Builder
    public Admin(Long id, String username, String password, String email, String phone, String name, String role, Boolean approved, String profileUrl, Timestamp createdAt, Cinema cinema) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.role = role;
        this.approved = approved;
        this.profileUrl = profileUrl;
        this.createdAt = createdAt;
        this.cinema = cinema;
    }
}