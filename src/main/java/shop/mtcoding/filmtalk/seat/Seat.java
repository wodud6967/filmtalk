package shop.mtcoding.filmtalk.seat;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.screen.Screen;

@Getter
@Setter
@Table(name = "seat_tb")
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;//성인 청소년 장애인

    private String grade;

    private Integer runTime;

    private String seatNumber;

    private char rowNum;   // 행 번호 (예: 'A', 'B', 'C' 등)
    private char colNum;   // 열 번호 (예: '1', '2', '3' 또는 'A', 'B', 'C' 등)
    private boolean reserved; // 예약 여부



    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;

    public Seat(Long id, String type, String grade, Integer runTime, String seatNumber, char rowNum, char colNum, boolean reserved, Screen screen) {
        this.id = id;
        this.type = type;
        this.grade = grade;
        this.runTime = runTime;
        this.seatNumber = seatNumber;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.reserved = reserved;
        this.screen = screen;
    }
}
