package HYLikeLion.gitppo.gitppoProject.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.repository.Portfolio.PortfolioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioRepositoryTest {

	@Autowired
	PortfolioRepository portfolioRepository;

	@After
	public void cleanup() {
		portfolioRepository.deleteAll();
	}

	@Test
	public void 포트폴리오저장_불러오기() {
		// given
		String name = "테스트용 포트폴리오";
		String uuid = UUID.randomUUID().toString();
		portfolioRepository.save(Portfolio.builder()
			.pfGrass(true)
			.pfName(name)
			.pfStar(true)
			.pfTemplate(1)
			.pfTmpSave(true)
			.pfUuid(uuid)
			.build());

		// when
		List<Portfolio> portfolioList = portfolioRepository.findAll();

		// then
		Portfolio portfolio = portfolioList.get(0);
		assertThat(portfolio.getPfName()).isEqualTo(name);
		assertThat(portfolio.getPfUuid()).isEqualTo(uuid);
	}
}
