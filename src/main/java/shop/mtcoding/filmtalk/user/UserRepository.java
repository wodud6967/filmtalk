package shop.mtcoding.filmtalk.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.seat.Seat;

public interface UserRepository extends JpaRepository<Seat, Long> {


    @Modifying
    @Transactional
    @Query("delete from Seat s where s.id=:id")
    void deleteById(@Param("id") Integer id);



}

