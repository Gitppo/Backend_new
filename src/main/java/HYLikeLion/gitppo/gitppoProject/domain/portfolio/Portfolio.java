package HYLikeLion.gitppo.gitppoProject.domain.portfolio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import HYLikeLion.gitppo.gitppoProject.domain.BaseTimeEntity;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Career;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.domain.repo.Repo;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Portfolio extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PF_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="USR_ID")
	private User user;

	@Column(nullable = false)
	private String pfName;

	private int pfTemplate;

	@Column(nullable = false, columnDefinition = "tinyint default 1")
	private Boolean pfGrass;

	@Column(nullable = false, columnDefinition = "tinyint default 1")
	private Boolean pfStar;

	@Column(nullable = false)
	private String pfUuid;

	@Column(nullable = false, columnDefinition = "tinyint default 1")
	private Boolean pfTmpSave;

	@OneToOne
	@JoinColumn(name = "PERSONAL_ID")
	private Personal personal;

	@OneToMany(mappedBy = "portfolio", orphanRemoval = true)
	private List<Repo> repo = new ArrayList<>();

	@Builder
	public Portfolio(User user, String pfName, int pfTemplate, Boolean pfGrass, Boolean pfStar, String pfUuid, Boolean pfTmpSave) {
		this.user = user;
		this.pfName = pfName;
		this.pfTemplate = pfTemplate;
		this.pfGrass = pfGrass;
		this.pfStar = pfStar;
		this.pfUuid = pfUuid;
		this.pfTmpSave = pfTmpSave;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void saveCompletely(int pfTemplate, Boolean pfTmpSave) {
		this.pfTemplate = pfTemplate;
		this.pfTmpSave = pfTmpSave;
	}
}
