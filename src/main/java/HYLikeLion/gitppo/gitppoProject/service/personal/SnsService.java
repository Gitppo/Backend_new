package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Sns;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.SnsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SnsService {

    private final SnsRepository snsRepository;

    @Transactional
    public void saveSns(List<Sns> sns, Personal personal) {
        for (Sns singleSns : sns) {
            singleSns.setPersonal(personal);
            snsRepository.save(singleSns);
        }
    }

    @Transactional
    public void deleteSns(Long id) {
        snsRepository.deleteById(id);
    }
}
