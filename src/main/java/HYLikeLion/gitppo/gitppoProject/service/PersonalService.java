package HYLikeLion.gitppo.gitppoProject.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.dto.PersonalDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.*;
import HYLikeLion.gitppo.gitppoProject.repository.Portfolio.PortfolioRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonalService {
	private final PersonalRepository personalRepository;
	private final IntroductionRepository introductionRepository;
	private final BasicInfoRepository basicInfoRepository;
	private final ActivityRepository activityRepository;
	private final AwardRepository awardRepository;
	private final CareerRepository careerRepository;
	private final EducationRepository educationRepository;
	private final PaperRepository paperRepository;
	private final SkillRepository skillRepository;
	private final SnsRepository snsRepository;
	private final LicenseRepository licenseRepository;

	private final PortfolioRepository portfolioRepository;

	@Transactional
	public Personal savePersonal(PersonalDTO.AddPersonal tmp) {
		// TO-DO: 검증 절차 추가해야될 것 같음.
		// TO-DO: 포트폴리오 연결 추가

		Portfolio portfolio = portfolioRepository.findById(tmp.getPfId())
			.orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. id=" + tmp.getPfId()));

		Personal personal = personalRepository.save(tmp.toEntity(portfolio));

		introductionRepository.save(tmp.getIntroduction());
		basicInfoRepository.save(tmp.getBasicInfo());

		tmp.getActivities().forEach(activity -> {
			activity.setPersonal(personal);
			activityRepository.save(activity);
		});

		tmp.getAwards().forEach(award -> {
			award.setPersonal(personal);
			awardRepository.save(award);
		});

		tmp.getLicenses().forEach(license -> {
			license.setPersonal(personal);
			licenseRepository.save(license);
		});

		tmp.getCareers().forEach(career -> {
			career.setPersonal(personal);
			careerRepository.save(career);
		});

		tmp.getEducations().forEach(education -> {
			education.setPersonal(personal);
			educationRepository.save(education);
		});

		tmp.getPapers().forEach(paper -> {
			paper.setPersonal(personal);
			paperRepository.save(paper);
		});

		tmp.getSkills().forEach(skill -> {
			skill.setPersonal(personal);
			skillRepository.save(skill);
		});

		tmp.getSnsList().forEach(sns -> {
			sns.setPersonal(personal);
			snsRepository.save(sns);
		});

		return personal;
	}

	public Personal getPersonal(Long id) throws NotFoundException {
		return personalRepository.findById(id).orElseThrow(() -> new NotFoundException(
			"Personal with id : " + id + "is not valid"));
	}

	public void deletePersonal(Long id) {
		personalRepository.deleteById(id);
	}
}
