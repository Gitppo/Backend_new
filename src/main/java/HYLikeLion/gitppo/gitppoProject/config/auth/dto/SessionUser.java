package HYLikeLion.gitppo.gitppoProject.config.auth.dto;

import java.io.Serializable;
import java.time.LocalDate;

import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private Long id;
	private String name;
	private String email;
	private Long githubId;
	private LocalDate loginDate;

	public SessionUser(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.githubId = user.getGithubId();
		this.loginDate = user.getLoginDate();
	}
}
