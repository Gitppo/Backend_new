package HYLikeLion.gitppo.gitppoProject.repository.skillList;

import org.springframework.data.jpa.repository.JpaRepository;

import HYLikeLion.gitppo.gitppoProject.domain.skillList.SkillContent;

public interface SkillListRepository extends JpaRepository<SkillContent, Long> {
}
