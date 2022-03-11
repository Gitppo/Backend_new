package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.BasicInfo;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.BasicInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BasicInfoService {

    private final BasicInfoRepository basicInfoRepository;

    @Transactional
    public void saveBasicInfo(BasicInfo basicInfo) {
        basicInfoRepository.save(basicInfo);
    }
}
