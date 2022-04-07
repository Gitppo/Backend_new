package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Paper;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.PaperRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaperService {

    private final PaperRepository paperRepository;

    @Transactional
    public void savePaper(List<Paper> papers, Personal personal) {
        for (Paper paper : papers) {
            paper.setPersonal(personal);
            paperRepository.save(paper);
        }
    }
    @Transactional
    public void deletePaper(Long id) {
        paperRepository.deleteById(id);
    }
}
