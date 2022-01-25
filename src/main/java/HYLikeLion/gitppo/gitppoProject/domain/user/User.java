package HYLikeLion.gitppo.gitppoProject.domain.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private Long githubId;

	private String email;

	@NonNull
	private LocalDate joinDate;

	@NonNull
	private LocalDate loginDate;

	@Enumerated(EnumType.STRING)
	@NonNull
	private Role role;

	@Builder
	public User(@NonNull String name, @NonNull Long githubId, String email, @NonNull LocalDate joinDate,
		@NonNull LocalDate loginDate, @NonNull Role role) {
		this.name = name;
		this.githubId = githubId;
		this.email = email;
		this.joinDate = joinDate;
		this.loginDate = loginDate;
		this.role = role;
	}



	public User update(String name, String email,LocalDate loginDate ) {
		this.name = name;
		this.email = email;
		this.loginDate = loginDate;
		return this;
	}

	public String getRoleKey() {
		return this.role.getKey();
	}
}
