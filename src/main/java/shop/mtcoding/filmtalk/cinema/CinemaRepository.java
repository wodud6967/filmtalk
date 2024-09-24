package shop.mtcoding.filmtalk.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.filmtalk.screen.Screen;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {





    @Query("select c from Cinema c join  fetch c.screens s")
    List<Cinema> mFindAllWithScreen();

    //@Query("SELECT c FROM Cinema c JOIN FETCH c.screens s JOIN FETCH s.showtimes st WHERE c.id = :id")
    @Query("select Distinct c from  Cinema c  join fetch c.screens s where c.id=:id")
    Cinema mFindByIdWithScreen(@Param("id") Long id);


    @Query("select c from  Cinema c  join fetch c.screens s where c.id=:id")
    Cinema mFindCinemaById(@Param("id") Long id);

    @Query("select c from Cinema c join fetch c.region r where c.id=:id")
    Cinema mFindCinemaRegionById(@Param("id") Long id);


}
