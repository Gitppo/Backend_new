package HYLikeLion.gitppo.gitppoProject.repository.Personal;

import org.springframework.data.jpa.repository.JpaRepository;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
	// List<Personal> findAllByPortfolio (Portfolio portfolio);
}

