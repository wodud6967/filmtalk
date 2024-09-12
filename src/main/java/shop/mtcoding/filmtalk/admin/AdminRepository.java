package shop.mtcoding.filmtalk.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.cinema.Cinema;
import shop.mtcoding.filmtalk.user.User;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("select a from Admin a where a.username=:username and a.password=:password")
    Optional<Admin> findByAdminUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
