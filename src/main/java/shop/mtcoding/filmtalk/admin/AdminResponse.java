package shop.mtcoding.filmtalk.admin;

import lombok.Data;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.Still;
import shop.mtcoding.filmtalk.movie.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class AdminResponse {

    @Data
    public static class MovieDTO {
        private String movieNm;
        private String openDt;
        private String runtime;
        private String ratingGrade;
        private String nationNm;
        private String posterUrl;
        private String vodUrl;
        private String plot;
        private String genreNm;
        private String company;
        private String director;
        private String actorNm;
        private List<String> stillUrls = new ArrayList<>();

        public MovieDTO(NeedData needData) {
            this.nationNm = needData.getNationNm();
            this.company = needData.getCompany();
            this.movieNm = needData.getMovieNm();
            this.openDt = needData.getOpenDt();
            this.runtime = needData.getRuntime();
            this.ratingGrade = needData.getRatingGrade();
            this.posterUrl = needData.getPosterUrls().getFirst().getUrl();
            this.vodUrl = needData.getVodUrl();
            this.plot = needData.getPlot();
            this.genreNm = needData.getGenreNm();
            this.director = needData.getDirector();
            this.actorNm = needData.getActorNm();
            for(Still s : needData.getStillUrls()) {
                stillUrls.add(s.getUrl());

            }
        }
    }
}
