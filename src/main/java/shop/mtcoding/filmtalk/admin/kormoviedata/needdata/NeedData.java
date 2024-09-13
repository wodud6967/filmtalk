package shop.mtcoding.filmtalk.admin.kormoviedata.needdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.filmtalk.admin.kormoviedata.kor.KorMovies;
import shop.mtcoding.filmtalk.admin.kormoviedata.kor.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class NeedData {

    private String movieNm;  //영화명 (국문)
    private String prdtYear;  //제작 연도
    private String openDt; // 개봉일
    private String nationNm;  //제작 국가명
    private String genreNm;  //장르명
    private String director; // 영화감독
    private String company;  //제작사
    private String runtime;  //상영시간
    private String ratingGrade; // 관람기준 ex)15세, 18세
    private String vodUrl;  //VOD URL
    private String plot;  //줄거리
    private String actorNm;  //배우명
    private List<Poster> posterUrls = new ArrayList<>(); //포스터 이미지 URL
    private List<Still> stillUrls = new ArrayList<>();  //스틸이미지URL

    public List<NeedData> parsingMovies(KorMovies korMovies) {
        List<NeedData> list = new ArrayList<NeedData>();
        for (Result a : korMovies.getData().getFirst().getResult()) {
            NeedData data = new NeedData();
            data.setMovieNm(removeSpecialCharacters(a.getTitle()));
            data.setPrdtYear(a.getProdYear());
            data.setOpenDt(a.getRepRlsDate());
            data.setNationNm(a.getNation());
            data.setGenreNm(a.getGenre());
            data.setDirector(a.getDirectors().getDirector().getFirst().getDirectorNm());
            data.setCompany(a.getCompany());
            data.setRuntime(a.getRuntime());
            data.setRatingGrade(a.getRatings().getRating().getFirst().getRatingGrade());
            data.setVodUrl(a.getVods().getVod().getFirst().getVodUrl());
            data.setPlot(a.getPlots().getPlot().getFirst().getPlotText());
            data.setActorNm(a.getActors().getActor().getFirst().getActorNm());
            List<String> splitPosterURL = splitUrls(a.getPosters());
            for (String s : splitPosterURL) {
                data.posterUrls.add(new Poster(s));
            }
            List<String> splitStillURL = splitUrls(a.getStlls());
            for (String s : splitStillURL) {
                data.stillUrls.add(new Still(s));
            }
            list.add(data);
        }
        return list;
    }
    private   List<String> splitUrls(String urls) {
        // split() 메소드를 사용해 | 기준으로 문자열을 분할
        return Arrays.asList(urls.split("\\|"));
    }

    private String removeSpecialCharacters(String input) {
        if (input != null) {
            // !HS와 !HE를 모두 제거
            return input.replace("!HS", "").replace("!HE", "");
        }
        return input;
    }

}