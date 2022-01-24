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

}
