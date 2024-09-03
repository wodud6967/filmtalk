package shop.mtcoding.filmtalk.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.PipedReader;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminQueryRepository adminQueryRepository;
}
