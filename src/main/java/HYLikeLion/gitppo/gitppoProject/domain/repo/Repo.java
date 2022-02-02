package HYLikeLion.gitppo.gitppoProject.domain.repo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import HYLikeLion.gitppo.gitppoProject.domain.BaseTimeEntity;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Repo extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RP_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="PF_ID")
	@Getter(AccessLevel.NONE)
	private Portfolio portfolio;

	@Column(nullable = false)
	private String rpName;

	@Column(columnDefinition = "TEXT")
	private String rpShortContents;

	@Column(columnDefinition = "TEXT")
	private String rpReadme;

	private Long rpStar;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate rpSdate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate rpEdate;

	@Column(columnDefinition = "TEXT")
	private String rpRole;

	@Column(columnDefinition = "TEXT")
	private String rpLongContents;

	@Builder
	public Repo(Portfolio portfolio, String rpName, String rpShortContents, String rpReadme, Long rpStar, LocalDate rpSdate, LocalDate rpEdate, String rpRole, String rpLongContents) {
		this.portfolio = portfolio;
		this.rpName = rpName;
		this.rpShortContents = rpShortContents;
		this.rpReadme = rpReadme;
		this.rpStar = rpStar;
		this.rpSdate = rpSdate;
		this.rpEdate = rpEdate;
		this.rpRole = rpRole;
		this.rpLongContents = rpLongContents;
	}

	public void update(String rpName, String rpShortContents, String rpReadme, Long rpStar, LocalDate rpSdate, LocalDate rpEdate, String rpRole, String rpLongContents) {
		this.rpName = rpName;
		this.rpShortContents = rpShortContents;
		this.rpReadme = rpReadme;
		this.rpStar = rpStar;
		this.rpSdate = rpSdate;
		this.rpEdate = rpEdate;
		this.rpRole = rpRole;
		this.rpLongContents = rpLongContents;
	}
}
