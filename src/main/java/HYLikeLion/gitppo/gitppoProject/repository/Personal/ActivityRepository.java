package HYLikeLion.gitppo.gitppoProject.repository.Personal;

import org.springframework.data.jpa.repository.JpaRepository;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
