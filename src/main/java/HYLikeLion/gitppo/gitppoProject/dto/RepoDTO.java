package HYLikeLion.gitppo.gitppoProject.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RepoDTO {

	@NoArgsConstructor
	@Getter
	public static class RequestRepo {
		private Long id;
		private String name;
		private String html_url;
		private String description;
		private Long stargazers_count;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Map<String, Long> languages;
		private String readme;

		@Builder
		public RequestRepo(Long id, String name, String html_url, String description, Long stargazers_count, LocalDate created_at, LocalDate updated_at) {
			this.id = id;
			this.name = name;
			this.html_url = html_url;
			this.description = description;
			this.stargazers_count = stargazers_count;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}

		public void setLanguages(Map<String, Long> languages) {
			this.languages = languages;
		}

		public void setReadme(String readme) {
			this.readme = readme;
		}

	}

	@NoArgsConstructor
	@Getter
	public static class ResponseList {
		private StatusEnum status;
		private String message;
		private List<RequestRepo> data;

		@Builder
		public ResponseList(StatusEnum status, String message, List<RequestRepo> data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class AddRepo {
		private Long pfId;
		private Long repoGitId;
		private String rpName;
		private String rpShortContents;
		private String rpReadme;
		private Long rpStar;
		private LocalDate rpSdate;
		private LocalDate rpEdate;
		private String rpRole;
		private String rpLongContents;


		@Builder
		public AddRepo(Long pfId, Long repoGitId, String rpName, String rpShortContents, String rpReadme, Long rpStar, LocalDate rpSdate, LocalDate rpEdate, String rpRole, String rpLongContents) {
			this.pfId = pfId;
			this.repoGitId = repoGitId;
			this.rpName = rpName;
			this.rpShortContents = rpShortContents;
			this.rpReadme = rpReadme;
			this.rpStar = rpStar;
			this.rpSdate = rpSdate;
			this.rpEdate = rpEdate;
			this.rpRole = rpRole;
			this.rpLongContents = rpLongContents;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class ResponseIds {
		private StatusEnum status;
		private String message;
		private List<Long> data;

		@Builder
		public ResponseIds(StatusEnum status, String message, List<Long> data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class EditRepo {
		private Long id;
		private String rpName;
		private String rpShortContents;
		private String rpReadme;
		private Long rpStar;
		private LocalDate rpSdate;
		private LocalDate rpEdate;
		private String rpRole;
		private String rpLongContents;
		private Long rpGpId;

		@Builder
		public EditRepo(Long id, String rpName, String rpShortContents, String rpReadme, Long rpStar, LocalDate rpSdate, LocalDate rpEdate, String rpRole, String rpLongContents, Long rpGpId) {
			this.id = id;
			this.rpName = rpName;
			this.rpShortContents = rpShortContents;
			this.rpReadme = rpReadme;
			this.rpStar = rpStar;
			this.rpSdate = rpSdate;
			this.rpEdate = rpEdate;
			this.rpRole = rpRole;
			this.rpLongContents = rpLongContents;
			this.rpGpId = rpGpId;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class AddRepoGroup {
		private Long pfId;
		private String gpName;

		@Builder
		public AddRepoGroup(Long pfId, String gpName) {
			this.pfId = pfId;
			this.gpName = gpName;
		}
	}

}
