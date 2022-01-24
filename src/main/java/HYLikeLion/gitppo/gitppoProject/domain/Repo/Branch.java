package HYLikeLion.gitppo.gitppoProject.domain.Repo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@NoArgsConstructor
public class Branch {

	private String name;

	@Builder
	public void Branch(String name) {
		this.name = name;
	}
}
