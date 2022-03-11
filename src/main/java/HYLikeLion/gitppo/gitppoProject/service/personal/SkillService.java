package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Skill;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.SkillRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Transactional
    public void saveSkill(List<Skill> skills, Personal personal) {
        for (Skill skill : skills) {
            skill.setPersonal(personal);
            skillRepository.save(skill);
        }
    }
    @Transactional
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
