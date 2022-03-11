package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Introduction;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.IntroductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class IntroductionService {

    private final IntroductionRepository introductionRepository;

    @Transactional
    public void saveIntroduction(Introduction introduction) {
        introductionRepository.save(introduction);
    }
}
