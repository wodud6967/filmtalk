package shop.mtcoding.filmtalk.region;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Builder
    public Region(Long id, String city, String name) {
        this.id = id;
        this.city = city;
        this.name = name;
    }
}
