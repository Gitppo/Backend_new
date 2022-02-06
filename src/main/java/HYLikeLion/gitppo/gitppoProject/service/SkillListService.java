package HYLikeLion.gitppo.gitppoProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import HYLikeLion.gitppo.gitppoProject.domain.skillList.SkillContent;
import HYLikeLion.gitppo.gitppoProject.repository.skillList.SkillListRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SkillListService {
	private final SkillListRepository skillListRepository;

	public List<SkillContent> findSkillList() {
		return skillListRepository.findAll();
	}
}
