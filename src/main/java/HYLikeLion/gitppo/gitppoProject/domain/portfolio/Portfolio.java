package HYLikeLion.gitppo.gitppoProject.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import HYLikeLion.gitppo.gitppoProject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@Entity
public class Portfolio extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PORTFOLIO_ID")
	private Long id;

	// @ManyToOne
	// @JoinColumn(name="USR_ID")
	// private User user;

	@NonNull
	private String pfName;

	private int pfTemplate;

	@NonNull
	@Column(columnDefinition = "tinyint default 1")
	private Boolean pfGrass;

	@NonNull
	@Column(columnDefinition = "tinyint default 1")
	private Boolean pfStar;

	@NonNull
	private String pfUuid;

	@NonNull
	@Column(columnDefinition = "tinyint default 1")
	private Boolean pfTmpSave;

	@Builder
	public Portfolio(/*User user, */ String pfName, int pfTemplate, Boolean pfGrass, Boolean pfStar, String pfUuid, Boolean pfTmpSave) {
		// this.user = user;
		this.pfName = pfName;
		this.pfTemplate = pfTemplate;
		this.pfGrass = pfGrass;
		this.pfStar = pfStar;
		this.pfUuid = pfUuid;
		this.pfTmpSave = pfTmpSave;
	}
}
