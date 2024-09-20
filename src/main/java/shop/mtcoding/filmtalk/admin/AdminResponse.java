package shop.mtcoding.filmtalk.admin;

import lombok.Data;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.Still;
import shop.mtcoding.filmtalk.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class AdminResponse {

    @Data
    public static class MovieDTO {
        private String movieNm;
        private String prdtYear;
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
        private boolean hasStills = false;
        private List<String> stillUrls = new ArrayList<>();

        public MovieDTO(NeedData needData) {
            this.nationNm = needData.getNationNm();
            this.prdtYear = needData.getPrdtYear();
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
            if (!needData.getStillUrls().getFirst().getUrl().equals("")) {
                this.hasStills = true;
                for (Still s : needData.getStillUrls()) {
                    stillUrls.add(s.getUrl());
                }
            }
        }
    }

    @Data
    public static class OwnedMovieDTO{
        private Long id;
        private String movieNm;
        private String openDt;
        private String ratingGrade;
        private String nationNm;
        private String posterUrl;
        private String genreNm;
        private String company;
        private String director;

        public OwnedMovieDTO(Movie movie){
            this.id=movie.getId();
            this.movieNm = movie.getMovieNm();
            this.openDt = movie.getOpenDt();
            this.ratingGrade = movie.getRatingGrade();
            this.nationNm = movie.getNationNm();
            this.posterUrl=movie.getPosterUrls().getFirst().getUrl();
            this.genreNm=movie.getGenreNm();
            this.company=movie.getCompany();
            this.director=movie.getDirector();
        }
    }
    @Data
    public static class OwnedMovieDetailDTO{
        private Long id;
        private String movieNm;
        private String prdtYear;
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
        private boolean hasStills = false;
        private List<String> stillUrls = new ArrayList<>();

        public OwnedMovieDetailDTO(Movie movie){
            this.id=movie.getId();
            this.movieNm = movie.getMovieNm();
            this.prdtYear = movie.getPrdtYear();
            this.openDt = movie.getOpenDt();
            this.runtime = movie.getRuntime().toString();
            this.ratingGrade = movie.getRatingGrade();
            this.nationNm = movie.getNationNm();
            this.posterUrl=movie.getPosterUrls().getFirst().getUrl();
            this.vodUrl=movie.getVodUrl();
            this.plot=movie.getPlot();
            this.genreNm=movie.getGenreNm();
            this.company=movie.getCompany();
            this.director=movie.getDirector();
            this.actorNm=movie.getActorNm();
            this.hasStills=false;
            if(movie.getStillUrls() !=null||!movie.getStillUrls().getFirst().getUrl().equals("")){
                this.hasStills=true;
                for (shop.mtcoding.filmtalk.still.Still s : movie.getStillUrls()){
                    stillUrls.add(s.getUrl());
                }
            }
        }
    }
}
