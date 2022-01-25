package HYLikeLion.gitppo.gitppoProject.repository.Personal;

import org.springframework.data.jpa.repository.JpaRepository;

import HYLikeLion.gitppo.gitppoProject.domain.personal.License;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long> {
}
