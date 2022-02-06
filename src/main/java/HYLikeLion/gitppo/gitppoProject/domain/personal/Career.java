package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Setter
@Getter
@Schema(description = "경력")
public class Career {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAREER_ID")
	private Long id;

	@NonNull
	@Schema(description = "경력명")
	private String carName;

	@NonNull
	@Schema(description = "부서명")
	private String carDepartmentName;

	@NonNull
	@Schema(description = "시작일")
	private LocalDate carStartDate;

	@NonNull
	@Schema(description = "종료일")
	private LocalDate carEndDate;

	@NonNull
	@Schema(description = "직무")
	private String carJob;

	@NonNull
	@Schema(description = "직책")
	private String carPosition;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	private Personal personal;
}
