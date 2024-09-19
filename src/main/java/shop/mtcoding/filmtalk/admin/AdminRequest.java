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
        @NotEmpty
        private String movieNm;
        @NotEmpty
        private String prdtYear;
        @NotEmpty
        private String openDt;
        @NotEmpty
        private String nationNm;
        @NotEmpty
        private String genreNm;
        @NotEmpty
        private String director;
        @NotEmpty
        private String company;
        @NotEmpty
        private String runtime;
        @NotEmpty
        @Pattern(regexp = "\\d{2}세", message = "두 자릿수 숫자와 한글 \"세\"가 조합된 형식을 요구합니다.")
        private String ratingGrade;
        @NotEmpty
        private String vodUrl;
        @NotEmpty
        private String plot;
        @NotEmpty
        private String actorNm;
        private List<String> posterUrls; // 포스터 이미지 URL 리스트
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
