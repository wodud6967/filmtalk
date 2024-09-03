package shop.mtcoding.filmtalk.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "movie_tb")
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String movieNm;  //영화명 (국문)
    @Column(nullable = false)
    private String prdtYear;  //제작 연도
    @Column(nullable = false)
    private String openDt; // 개봉일
    @Column(nullable = false)
    private String nationNm;  //제작 국가명
    @Column(nullable = false)
    private String genreNm;  //장르명
    @Column(nullable = false)
    private String director; // 영화감독
    @Column(nullable = false)
    private String company;  //제작사
    @Column(nullable = false)
    private String posterUrl; //포스터 이미지 URL
    @Column(nullable = false)
    private String runtime;  //상영시간
    @Column(nullable = false)
    private String ratingGrade; // 관람기준 ex)15세, 18세
    @Column(nullable = false)
    private String audiAcc;  // 누적 관객
    @Column(nullable = false)
    private String vodUrl;  //VOD URL
    @Column(nullable = false)
    private String plot;  //줄거리
    @Column(nullable = false)
    private String actorNm;  //배우명
    @Column(nullable = false)
    private String stillUrl;  //스틸이미지URL

    private Long apiId; //추후 api등록

    public Movie(Long id, String movieNm, String prdtYear, String openDt, String nationNm, String genreNm, String director, String company, String posterUrl, String runtime, String ratingGrade, String audiAcc, String vodUrl, String plot, String actorNm, String stillUrl, Long apiId) {
        this.id = id;
        this.movieNm = movieNm;
        this.prdtYear = prdtYear;
        this.openDt = openDt;
        this.nationNm = nationNm;
        this.genreNm = genreNm;
        this.director = director;
        this.company = company;
        this.posterUrl = posterUrl;
        this.runtime = runtime;
        this.ratingGrade = ratingGrade;
        this.audiAcc = audiAcc;
        this.vodUrl = vodUrl;
        this.plot = plot;
        this.actorNm = actorNm;
        this.stillUrl = stillUrl;
        this.apiId = apiId;
    }
}
