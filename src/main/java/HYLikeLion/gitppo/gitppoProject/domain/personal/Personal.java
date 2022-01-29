package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Setter
@Getter
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSONAL_ID")
	private Long id;

	@OneToOne(mappedBy = "personal", orphanRemoval = true)
	@Getter(AccessLevel.NONE)
	private Portfolio portfolio;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "INTRO_ID")
	private Introduction introduction;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "BASICINFO_ID")
	private BasicInfo basicInfo;

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Career> careers = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Education> educations = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<License> licenses = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Activity> activities = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Award> awards = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Sns> snsList = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Skill> skills = new ArrayList<>();

	@OneToMany(mappedBy = "personal", orphanRemoval = true)
	private List<Paper> papers = new ArrayList<>();
}
