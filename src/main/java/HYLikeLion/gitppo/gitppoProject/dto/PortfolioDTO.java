package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;
import java.util.UUID;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.domain.repo.Repo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PortfolioDTO {

	@NoArgsConstructor
	@Getter
	public static class AddPortfolio {
		private String pfName;
		private Boolean pfStar;

		@Builder
		public AddPortfolio(String pfName, Boolean pfStar) {
			this.pfName = pfName;
			this.pfStar = pfStar;
		}

		public Portfolio toEntity() {
			return Portfolio.builder()
				.pfName(pfName)
				.pfTemplate(0)
				.pfStar(pfStar)
				.pfUuid(UUID.randomUUID().toString())
				.pfTmpSave(true)
				.build();
		}
	}

	@NoArgsConstructor
	@Getter
	public static class EditPortfolio {
		private String pfName;
		private Boolean pfStar;
		private Long id;

		@Builder
		public EditPortfolio(String pfName, Boolean pfStar, Long id) {
			this.pfName = pfName;
			this.pfStar = pfStar;
			this.id = id;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class GetPortfolio {
		private Long id;
		private Long usrId;
		private String pfName;
		private int pfTemplate;
		private Boolean pfStar;
		private String pfUuid;
		private Boolean pfTmpSave;

		@Builder
		public GetPortfolio(Long id, Long usrId, String pfName, int pfTemplate, Boolean pfStar, String pfUuid, Boolean pfTmpSave) {
			this.id = id;
			this.usrId = usrId;
			this.pfName = pfName;
			this.pfTemplate = pfTemplate;
			this.pfStar = pfStar;
			this.pfUuid = pfUuid;
			this.pfTmpSave = pfTmpSave;
		}

		public static GetPortfolio from(Portfolio p) {
			return new GetPortfolio(p.getId(), p.getUser().getId(), p.getPfName(), p.getPfTemplate(), p.getPfStar(), p.getPfUuid(), p.getPfTmpSave());
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

	@NoArgsConstructor
	@Getter
	public static class SavePortfolio {
		private Long pfId;
		private int pfTemplate;

		@Builder
		public SavePortfolio(Long pfId, int pfTemplate) {
			this.pfId = pfId;
			this.pfTemplate = pfTemplate;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class GetAllPortfolio {
		private Long id;
		private Long usrId;
		private String pfName;
		private int pfTemplate;
		private Boolean pfStar;
		private String pfUuid;
		private Boolean pfTmpSave;
		private Personal personal;
		private List<Repo> repo;

		@Builder
		public GetAllPortfolio(Long id, Long usrId, String pfName, int pfTemplate, Boolean pfStar, String pfUuid, Boolean pfTmpSave, Personal personal, List<Repo> repo) {
			this.id = id;
			this.usrId = usrId;
			this.pfName = pfName;
			this.pfTmpSave = pfTmpSave;
			this.pfStar = pfStar;
			this.pfUuid = pfUuid;
			this.pfTemplate = pfTemplate;
			this.personal = personal;
			this.repo = repo;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class ResponsePortfolio {
		private StatusEnum status;
		private String message;
		private GetAllPortfolio data;

		@Builder
		public ResponsePortfolio(StatusEnum status, String message, GetAllPortfolio data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}
}
