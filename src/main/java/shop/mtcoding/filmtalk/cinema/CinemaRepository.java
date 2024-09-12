package shop.mtcoding.filmtalk.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {



    //bag 오류 onetomany 두번사용 컬렉션 +컬렉션 오류
  /*  @Query("SELECT c FROM Cinema c " +
            "JOIN FETCH c.screens scr " +
            "JOIN FETCH scr.showtimes " +
            "WHERE c.id = :cinemaId")
    Cinema findCinemaWithScreensAndShowtimes(@Param("cinemaId") Long cinemaId);*/

    //@Query("SELECT c FROM Cinema c JOIN FETCH c.screens s JOIN FETCH s.showtimes st WHERE c.id = :id")
    @Query("select Distinct c from  Cinema c  join fetch c.screens s where c.id=:id")
    Cinema mFindCinemaById(@Param("id") Long id);
}

