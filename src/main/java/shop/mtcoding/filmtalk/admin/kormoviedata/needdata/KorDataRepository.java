package shop.mtcoding.filmtalk.admin.kormoviedata.needdata;

import org.springframework.stereotype.Repository;
import shop.mtcoding.filmtalk.admin.kormoviedata.kor.KorMovies;
import shop.mtcoding.filmtalk.admin.kormoviedata.kor.KorRepo;
import shop.mtcoding.filmtalk.core.error.ex.Exception404;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Repository
public class KorDataRepository {

public List<NeedData> getRawMovie() {
    try {
        KorRepo korRepo = new KorRepo();
        KorMovies movies = korRepo.getMovies();
        NeedData data = new NeedData();
        List<NeedData> datas = data.parsingMovies(movies);
        return datas;

    } catch (UnsupportedEncodingException e) {
        throw new Exception404("영화 api를 찾을 수 없습니다.");
    }
}
}
