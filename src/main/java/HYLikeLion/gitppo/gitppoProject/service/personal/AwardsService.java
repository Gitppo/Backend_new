package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Award;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.AwardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AwardsService {

    private final AwardRepository awardRepository;

    @Transactional
    public void saveAwards(List<Award> awards, Personal personal) {
        for (Award award : awards) {
            award.setPersonal(personal);
            awardRepository.save(award);
        }

    }
    @Transactional
    public void deleteAward(Long id) {
        awardRepository.deleteById(id);
    }
}
