package shop.mtcoding.filmtalk.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.seat.Seat;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {





    @Query("select u from User u where u.username=:username")
    Optional<User> mFindByUsername(@Param("username") String username);

    @Query("select u from User u where u.username=:username and u.password=:password")
    Optional<User> mFindByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


}

