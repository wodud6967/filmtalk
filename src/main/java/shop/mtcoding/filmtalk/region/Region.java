package shop.mtcoding.filmtalk.region;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.cinema.Cinema;

import java.util.List;

@Getter
@Setter
@Table(name = "region_tb")
@NoArgsConstructor
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String name;

    //TODO 추가함 9/19 주헌 영화관 list 뽑으려고
    @OneToMany(mappedBy = "region")
    private List<Cinema> cinemas;

    @Builder
    public Region(Long id, String city, String name) {
        this.id = id;
        this.city = city;
        this.name = name;
    }
}
