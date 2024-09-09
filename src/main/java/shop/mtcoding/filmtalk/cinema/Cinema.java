package shop.mtcoding.filmtalk.cinema;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.region.Region;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "cinema_tb")
@NoArgsConstructor
@Entity
public class Cinema { //영화관 테이블
    //TODO: 주석추가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;



    private String imgName;

    @Column(length = 500)
    private String imgUname;


    private String name;



    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;


    @Builder
    public Cinema(Long id, String imgName, String imgUname, String name, Region region) {
        this.id = id;
        this.imgName = imgName;
        this.imgUname = imgUname;
        this.name = name;
        this.region = region;
    }
}
