package shop.mtcoding.filmtalk.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RegionService {
    private final RegionRepository regionRepository;
    private final RegionQueryRepository regionQueryRepository;

    //지역 찾기
    public List<Region> 지역보기(){
        List<Region> region = regionRepository.findAll();
        return region;
    }
}
