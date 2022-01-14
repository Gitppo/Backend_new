package HYLikeLion.gitppo.gitppoProject.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;

public class PortfolioResponseDTOTest {

	@Test
	public void 롬복_기능_테스트() {
		// given
		String message = "test";
		List<Portfolio> data = new ArrayList<>();

		// when
		PortfolioResponseDTO.GetPortfolio dto = PortfolioResponseDTO.GetPortfolio.builder()
			.status(StatusEnum.OK)
			.data(data)
			.message(message)
			.build();

		// then
		assertThat(dto.getMessage()).isEqualTo(message);
		assertThat(dto.getData()).isEqualTo(data);
	}
}
