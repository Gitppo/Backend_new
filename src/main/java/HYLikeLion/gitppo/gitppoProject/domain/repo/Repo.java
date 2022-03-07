package HYLikeLion.gitppo.gitppoProject.domain.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import HYLikeLion.gitppo.gitppoProject.domain.BaseTimeEntity;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Schema(description = "레포지토리")
public class Repo extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RP_ID")
	private Long id;

	@Column(nullable = false)
	@Schema(description = "레포 깃 아이디")
	private Long repoGitId;

	@ManyToOne
	@JoinColumn(name = "PF_ID")
	@Getter(AccessLevel.NONE)
	private Portfolio portfolio;

	@Column(nullable = false)
	@Schema(description = "레포 이름")
	private String rpName;

	@Column(columnDefinition = "TEXT")
	@Schema(description = "짧은 내용")
	private String rpShortContents;

	@Column(columnDefinition = "TEXT")
	@Schema(description = "리드미")
	private String rpReadme;

	@Schema(description = "스타 개수")
	private Long rpStar;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Schema(description = "시작일")
	private LocalDate rpSdate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Schema(description = "종료일")
	private LocalDate rpEdate;

	@Column(columnDefinition = "TEXT")
	@Schema(description = "역할")
	private String rpRole;

	@Column(columnDefinition = "TEXT")
	@Schema(description = "긴 내용")
	private String rpLongContents;

	@ElementCollection
	@Schema(description = "언어")
	private Map<String, Long> rpLanguages = new HashMap<>();

	@ElementCollection
	@Schema(description = "스킬")
	private List<String> rpSkills = new ArrayList<>();

	@Builder
	public Repo(Portfolio portfolio, Long repoGitId, String rpName, String rpShortContents, String rpReadme, Long rpStar, LocalDate rpSdate, LocalDate rpEdate, String rpRole, String rpLongContents, Map<String, Long> rpLanguages, List<String> rpSkills) {
		this.portfolio = portfolio;
		this.repoGitId = repoGitId;
		this.rpName = rpName;
		this.rpShortContents = rpShortContents;
		this.rpReadme = rpReadme;
		this.rpStar = rpStar;
		this.rpSdate = rpSdate;
		this.rpEdate = rpEdate;
		this.rpRole = rpRole;
		this.rpLongContents = rpLongContents;
		this.rpLanguages = rpLanguages;
		this.rpSkills = rpSkills;
	}

	public void update(String rpName, String rpShortContents, String rpReadme, Long rpStar, LocalDate rpSdate, LocalDate rpEdate, String rpRole, String rpLongContents, Map<String, Long> rpLanguages, List<String> rpSkills) {
		this.rpName = rpName;
		this.rpShortContents = rpShortContents;
		this.rpReadme = rpReadme;
		this.rpStar = rpStar;
		this.rpSdate = rpSdate;
		this.rpEdate = rpEdate;
		this.rpRole = rpRole;
		this.rpLongContents = rpLongContents;
		this.rpLanguages = rpLanguages;
		this.rpSkills = rpSkills;
	}
}
