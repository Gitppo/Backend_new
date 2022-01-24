package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;
import java.util.UUID;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PortfolioDTO {

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

	@NoArgsConstructor
	@Getter
	public static class GetPortfolio {
		private Long id;
		private Long usrId;
		private String pfName;
		private int pfTemplate;
		private Boolean pfGrass;
		private Boolean pfStar;
		private String pfUuid;
		private Boolean pfTmpSave;

		@Builder
		public GetPortfolio(Long id, Long usrId, String pfName, int pfTemplate, Boolean pfGrass, Boolean pfStar, String pfUuid, Boolean pfTmpSave) {
			this.id = id;
			this.usrId = usrId;
			this.pfName = pfName;
			this.pfTemplate = pfTemplate;
			this.pfGrass = pfGrass;
			this.pfStar = pfStar;
			this.pfUuid = pfUuid;
			this.pfTmpSave = pfTmpSave;
		}

		public static GetPortfolio from(Portfolio p) {
			return new GetPortfolio(p.getId(), p.getUser().getId(), p.getPfName(), p.getPfTemplate(), p.getPfGrass(), p.getPfStar(), p.getPfUuid(), p.getPfTmpSave());
		}
	}

	@NoArgsConstructor
	@Getter
	public static class ResponseList {
		private StatusEnum status;
		private String message;
		private List<GetPortfolio> data;

		@Builder
		public ResponseList(StatusEnum status, String message, List<GetPortfolio> data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}

}
