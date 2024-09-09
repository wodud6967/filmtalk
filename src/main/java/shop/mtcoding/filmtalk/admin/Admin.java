package shop.mtcoding.filmtalk.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String role; // ROLE_ADMIN, ROLE_SUPERADMIN 등

    @Column(nullable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;



    public Admin(Long id, String username, String password, String email, String phone, String role, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
    }
}
