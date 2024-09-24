package shop.mtcoding.filmtalk.admin;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import shop.mtcoding.filmtalk.movie.Movie;
import shop.mtcoding.filmtalk.poster.Poster;
import shop.mtcoding.filmtalk.still.Still;

import java.util.List;

public class AdminRequest {
    @Data
    public static class SaveMovieDTO {
        @NotEmpty(message = "영화 제목은 필수 입력 항목입니다.")
        private String movieNm;

        @NotEmpty(message = "제작 연도는 필수 입력 항목입니다.")
        private String prdtYear;

        @NotEmpty(message = "개봉일은 필수 입력 항목입니다.")
        private String openDt;

        @NotEmpty(message = "제작 국가는 필수 입력 항목입니다.")
        private String nationNm;

        @NotEmpty(message = "장르명은 필수 입력 항목입니다.")
        private String genreNm;

        @NotEmpty(message = "영화 감독 이름은 필수 입력 항목입니다.")
        private String director;

        @NotEmpty(message = "제작사는 필수 입력 항목입니다.")
        private String company;

        @NotEmpty(message = "러닝타임은 필수 입력 항목입니다.")
        private String runtime;

        @NotEmpty(message = "관람 등급은 필수 입력 항목입니다.")
        @Pattern(regexp = "(\\d{2}세|전체)", message = "관람 등급은 '전체' 또는 두 자릿수 숫자와 '세'로 입력해야 합니다. 예: 12세, 15세, 전체")
        private String ratingGrade;


        @NotEmpty(message = "VOD URL은 필수 입력 항목입니다.")
        private String vodUrl;

        @NotEmpty(message = "줄거리는 필수 입력 항목입니다.")
        private String plot;

        @NotEmpty(message = "배우명은 필수 입력 항목입니다.")
        private String actorNm;

        @NotEmpty(message = "포스터URL은 필수 입력 항목입니다.")
        private List<String> posterUrls; // 포스터 이미지 URL 리스트
        @NotEmpty(message = "스틸컷URL은 필수 입력 항목입니다.")
        private List<String> stillUrls;  // 스틸컷 이미지 URL 리스트

        public Movie toEntity() {
            Movie movie = Movie.builder()
                    .movieNm(movieNm)
                    .prdtYear(prdtYear)
                    .openDt(openDt)
                    .nationNm(nationNm)
                    .genreNm(genreNm)
                    .director(director)
                    .company(company)
                    .runtime(Integer.valueOf(runtime))
                    .ratingGrade(ratingGrade)
                    .vodUrl(vodUrl)
                    .plot(plot)
                    .actorNm(actorNm)
                    .build();

            // Poster와 Still 객체 생성 및 Movie 객체와 연결
            List<Poster> posters = posterUrls.stream()
                    .map(url -> new Poster(url, movie))
                    .toList();

            List<Still> stills = stillUrls.stream()
                    .map(url -> new Still(url, movie))
                    .toList();

            // Movie 객체에 Poster와 Still 리스트를 설정
            movie.setPosterUrls(posters);
            movie.setStillUrls(stills);
            return movie;

        }


    }
}