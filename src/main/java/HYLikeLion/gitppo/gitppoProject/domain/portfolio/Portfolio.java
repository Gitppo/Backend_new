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

import com.sun.org.apache.xpath.internal.operations.Bool;

import HYLikeLion.gitppo.gitppoProject.domain.BaseTimeEntity;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Career;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.domain.repo.Repo;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Schema(description = "포트폴리오")
public class Portfolio extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PF_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="ID")
	private User user;

	@Column(nullable = false)
	@Schema(description = "제목")
	private String pfName;

	@Schema(description = "디자인 템플릿 번호")
	private int pfTemplate;

	@Column(nullable = false, columnDefinition = "tinyint default 1")
	@Schema(description = "스타 노출 여부")
	private Boolean pfStar;

	@Column(nullable = false)
	@Schema(description = "uuid")
	private String pfUuid;

	@Column(nullable = false, columnDefinition = "tinyint default 1")
	@Schema(description = "임시저장 여부")
	private Boolean pfTmpSave;

	@Column(nullable = false, columnDefinition = "tinyint default 1")
	@Schema(description = "공유 여부")
	private Boolean pfShare;

	@OneToOne
	@JoinColumn(name = "PERSONAL_ID")
	private Personal personal;

	@OneToMany(mappedBy = "portfolio", orphanRemoval = true)
	private List<Repo> repo = new ArrayList<>();

	@Builder
	public Portfolio(User user, String pfName, int pfTemplate, Boolean pfStar, String pfUuid, Boolean pfTmpSave, Boolean pfShare) {
		this.user = user;
		this.pfName = pfName;
		this.pfTemplate = pfTemplate;
		this.pfStar = pfStar;
		this.pfUuid = pfUuid;
		this.pfTmpSave = pfTmpSave;
		this.pfShare = pfShare;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void saveCompletely(int pfTemplate, Boolean pfTmpSave, Boolean pfShare) {
		this.pfTemplate = pfTemplate;
		this.pfTmpSave = pfTmpSave;
		this.pfShare = pfShare;
	}

	public void update(String pfName, Boolean pfStar) {
		this.pfName = pfName;
		this.pfStar = pfStar;
	}
}
