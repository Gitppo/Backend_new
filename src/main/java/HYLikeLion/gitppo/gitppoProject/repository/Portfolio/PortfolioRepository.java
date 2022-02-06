package HYLikeLion.gitppo.gitppoProject.repository.Portfolio;

import java.util.List;
import java.util.Optional;

import javax.sound.sampled.Port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
	List<Portfolio> findByUser(@Param("user") User user);
	Optional<Portfolio> findByPfUuid(@Param("pfUuid") String pfUuid);
}
