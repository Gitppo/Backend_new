package HYLikeLion.gitppo.gitppoProject.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import HYLikeLion.gitppo.gitppoProject.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByGithubId(Long githubId);
}
