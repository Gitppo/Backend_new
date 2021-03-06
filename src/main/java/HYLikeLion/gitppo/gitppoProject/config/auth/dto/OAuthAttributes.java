package HYLikeLion.gitppo.gitppoProject.config.auth.dto;

import java.time.LocalDate;
import java.util.Map;

import HYLikeLion.gitppo.gitppoProject.domain.user.Role;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private Long githubId;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email,
		Long githubId) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.githubId = githubId;
	}

	public static OAuthAttributes ofGithub(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
			.name(String.valueOf(attributes.get("name")))
			.email(String.valueOf(attributes.get("email")))
			.githubId(((Integer)attributes.get("id")).longValue())
			.attributes(attributes)
			.nameAttributeKey(userNameAttributeName)
			.build();
	}

	public User toEntity() {
		return User.builder()
			.name(name)
			.email(email)
			.role(Role.USER)
			.githubId(githubId)
			.joinDate(LocalDate.now())
			.loginDate(LocalDate.now())
			.build();
	}
}
