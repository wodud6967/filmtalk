package shop.mtcoding.filmtalk.screen;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.seat.Seat;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "screen_tb")
@NoArgsConstructor
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // 상영관 종류 특별관 일반관 ?????



    private Timestamp modifiedAt;
    private Timestamp createdAt;

    //totalseat 총 좌석수?

    @Builder
    public Screen(Long id, String name, String type, Timestamp modifiedAt, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }
}
