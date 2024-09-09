package shop.mtcoding.filmtalk.seat;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.screen.Screen;
import shop.mtcoding.filmtalk.showtime.Showtime;

@Getter
@Setter
@Table(name = "seat_tb")
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Showtime showtime;



    private String seatNumber;

    private char rowNum;   // 행 번호 (예: 'A', 'B', 'C' 등)
    private char colNum;   // 열 번호 (예: '1', '2', '3' 또는 'A', 'B', 'C' 등)




    public Seat(Long id,  String seatNumber, char rowNum, char colNum) {
        this.id = id;

        this.seatNumber = seatNumber;
        this.rowNum = rowNum;
        this.colNum = colNum;

    }
}
