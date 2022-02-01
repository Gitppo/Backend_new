package HYLikeLion.gitppo.gitppoProject.domain.repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Schema(description = "레포지토리 그룹")
public class RepoGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RP_GP_ID")
	private Long id;

	@Column(nullable = false)
	@Schema(description = "그룹명")
	private String gpName;

	@ManyToOne
	@JoinColumn(name = "PF_ID")
	private Portfolio portfolio;

	@Builder
	public RepoGroup(String gpName, Portfolio portfolio) {
		this.gpName = gpName;
		this.portfolio = portfolio;
	}
}
