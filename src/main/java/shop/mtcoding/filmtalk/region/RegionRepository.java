package shop.mtcoding.filmtalk.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query("SELECT rt FROM Region rt JOIN fetch rt.cinemas ct where rt.id =:id")
    public Optional<Region> mfindByIdWithCinemas(@Param("id") Long id);



}
