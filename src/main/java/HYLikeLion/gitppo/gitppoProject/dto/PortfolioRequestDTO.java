package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.UUID;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PortfolioRequestDTO {

	@NoArgsConstructor
	@Getter
	public static class AddPortfolio {
		private String pfName;
		private Boolean pfGrass;
		private Boolean pfStar;

		@Builder
		public AddPortfolio(String pfName, Boolean pfGrass, Boolean pfStar) {
			this.pfName = pfName;
			this.pfGrass = pfGrass;
			this.pfStar = pfStar;
		}

		public Portfolio toEntity() {
			return Portfolio.builder()
				.pfName(pfName)
				.pfTemplate(0)
				.pfGrass(pfGrass)
				.pfStar(pfStar)
				.pfUuid(UUID.randomUUID().toString())
				.pfTmpSave(true)
				.build();
		}
	}
}
