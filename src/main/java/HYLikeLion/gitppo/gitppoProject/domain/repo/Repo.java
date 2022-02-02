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
import io.swagger.v3.oas.annotations.media.Schema;
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

	@ManyToOne
	@JoinColumn(name = "PF_ID")
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
