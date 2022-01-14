package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PortfolioResponseDTO {

	@NoArgsConstructor
	@Getter
	public static class GetPortfolio {
		private StatusEnum status;
		private String message;
		private List<Portfolio> data;

		@Builder
		public GetPortfolio(StatusEnum status, List<Portfolio> data, String message) {
			this.status = status;
			this.data = data;
			this.message = message;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class AddPortfolio {
		private StatusEnum status;
		private String message;
		private Long id;

		@Builder
		public AddPortfolio(StatusEnum status, Long id, String message) {
			this.status = status;
			this.id = id;
			this.message = message;
		}
	}

}
