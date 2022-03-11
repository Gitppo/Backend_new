package HYLikeLion.gitppo.gitppoProject.service;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Activity;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Award;
import HYLikeLion.gitppo.gitppoProject.domain.personal.BasicInfo;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Career;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Education;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Introduction;
import HYLikeLion.gitppo.gitppoProject.domain.personal.License;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Paper;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Skill;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Sns;
import HYLikeLion.gitppo.gitppoProject.dto.PersonalDTO.EditPersonal;
import HYLikeLion.gitppo.gitppoProject.service.personal.ActivityService;
import HYLikeLion.gitppo.gitppoProject.service.personal.AwardsService;
import HYLikeLion.gitppo.gitppoProject.service.personal.BasicInfoService;
import HYLikeLion.gitppo.gitppoProject.service.personal.CareerService;
import HYLikeLion.gitppo.gitppoProject.service.personal.EducationService;
import HYLikeLion.gitppo.gitppoProject.service.personal.IntroductionService;
import HYLikeLion.gitppo.gitppoProject.service.personal.LicenseService;
import HYLikeLion.gitppo.gitppoProject.service.personal.PaperService;
import HYLikeLion.gitppo.gitppoProject.service.personal.SkillService;
import HYLikeLion.gitppo.gitppoProject.service.personal.SnsService;
import java.time.Period;
import java.util.List;
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
    private final PortfolioRepository portfolioRepository;

    private final ActivityService activityService;
    private final AwardsService awardsService;
    private final BasicInfoService basicInfoService;
    private final CareerService careerService;
    private final EducationService educationService;
    private final IntroductionService introductionService;
    private final LicenseService licenseService;
    private final PaperService paperService;
    private final SkillService skillService;
    private final SnsService snsService;

    @Transactional
    public Personal savePersonal(PersonalDTO.AddPersonal tmp) {

        Portfolio portfolio = portfolioRepository.findById(tmp.getPfId())
            .orElseThrow(
                () -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. id=" + tmp.getPfId()));

        Personal personal = personalRepository.save(tmp.toEntity(portfolio));
        portfolio.setPersonal(personal);

        savePersonalInfo(personal, tmp.getActivities(), tmp.getAwards(), tmp.getBasicInfo(),
            tmp.getCareers(), tmp.getEducations(), tmp.getIntroduction(), tmp.getLicenses(),
            tmp.getPapers(), tmp.getSkills(), tmp.getSnsList());

        portfolioRepository.save(portfolio);
        return personal;
    }

    public void deletePersonal(Long id) {
        personalRepository.deleteById(id);
    }

    public Personal editPersonal(EditPersonal dto) throws NotFoundException {
        Portfolio portfolio = portfolioRepository.findById(dto.getPfId())
            .orElseThrow(
                () -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. id=" + dto.getPfId()));

        Personal newPersonal = dto.toEntity(portfolio);

        personalRepository.save(newPersonal);


        savePersonalInfo(newPersonal, dto.getActivities(), dto.getAwards(), dto.getBasicInfo(),
            dto.getCareers(), dto.getEducations(), dto.getIntroduction(), dto.getLicenses(),
            dto.getPapers(), dto.getSkills(), dto.getSnsList());


        return newPersonal;
    }

    public Personal getPersonal(Long id) throws NotFoundException {
        return personalRepository.findById(id).orElseThrow(() -> new NotFoundException(
            "Personal with id : " + id + "is not valid"));
    }

    private void savePersonalInfo(Personal personal, List<Activity> activities, List<Award> awards,
        BasicInfo basicInfo, List<Career> careers, List<Education> educations,
        Introduction introduction, List<License> licenses, List<Paper> papers, List<Skill> skills,
        List<Sns> snsList) {
        activityService.setActivities(activities, personal);
        awardsService.saveAwards(awards, personal);
        basicInfoService.saveBasicInfo(basicInfo);
        careerService.saveCareer(careers, personal);
        educationService.saveEducation(educations, personal);
        introductionService.saveIntroduction(introduction);
        licenseService.saveLicense(licenses, personal);
        paperService.savePaper(papers, personal);
        skillService.saveSkill(skills, personal);
        snsService.saveSns(snsList, personal);
    }
}
