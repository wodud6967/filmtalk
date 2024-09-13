package shop.mtcoding.filmtalk.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.KorDataRepository;
import shop.mtcoding.filmtalk.admin.kormoviedata.needdata.NeedData;

import java.util.List;

@Import(KorDataRepository.class)
@DataJpaTest
public class KorDataRepositoryTest {

    @Autowired
    KorDataRepository korDataRepository;

    @Test
    public void getRawMovie_test(){
        List<NeedData> rawMovie = korDataRepository.getRawMovie();

        Assertions.assertNotNull(rawMovie);



    }
}
