package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;

import HYLikeLion.gitppo.gitppoProject.domain.term.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PortfolioDTO {

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
}
