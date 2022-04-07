package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Career;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.CareerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CareerService {

    private final CareerRepository careerRepository;

    @Transactional
    public void saveCareer(List<Career> careers, Personal personal) {
        for (Career career : careers) {
            career.setPersonal(personal);
            careerRepository.save(career);
        }
    }
    @Transactional
    public void deleteCareer(Long id) {
        careerRepository.deleteById(id);
    }
}
