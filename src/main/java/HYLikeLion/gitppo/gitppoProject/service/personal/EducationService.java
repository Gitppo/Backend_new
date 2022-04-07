package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Education;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.EducationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EducationService {

    private final EducationRepository educationRepository;

    @Transactional
    public void saveEducation(List<Education> educations, Personal personal) {
        for (Education education : educations) {
            education.setPersonal(personal);
            educationRepository.save(education);
        }
    }
    @Transactional
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
