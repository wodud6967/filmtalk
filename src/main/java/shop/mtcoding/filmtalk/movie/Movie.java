package shop.mtcoding.filmtalk.movie;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.filmtalk.comment.Comment;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.still.Still;

import java.util.List;


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
    private Integer runtime;  //상영시간
    @Column(nullable = false)
    private String ratingGrade; // 관람기준 ex)15세, 18세
    @Column(nullable = false)
    private String vodUrl;  //VOD URL
    @Column(nullable = false, length = 1000)
    private String plot;  //줄거리
    @Column(nullable = false)
    private String actorNm;  //배우명
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Poster> posterUrls;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Still> stillUrls;
    @OneToMany(mappedBy = "movie")
    private List<Comment> comments;

    private Long apiId; //추후 api등록

    @Builder
    public Movie(Long id, String movieNm, String prdtYear, String openDt, String nationNm, String genreNm, String director, String company, Integer runtime, String ratingGrade, String vodUrl, String plot, String actorNm, List<Poster> posterUrls, List<Still> stillUrls, List<Comment> comments, Long apiId) {
        this.id = id;
        this.movieNm = movieNm;
        this.prdtYear = prdtYear;
        this.openDt = openDt;
        this.nationNm = nationNm;
        this.genreNm = genreNm;
        this.director = director;
        this.company = company;
        this.runtime = runtime;
        this.ratingGrade = ratingGrade;
        this.vodUrl = vodUrl;
        this.plot = plot;
        this.actorNm = actorNm;
        this.posterUrls = posterUrls;
        this.stillUrls = stillUrls;
        this.comments = comments;
        this.apiId = apiId;
    }
}