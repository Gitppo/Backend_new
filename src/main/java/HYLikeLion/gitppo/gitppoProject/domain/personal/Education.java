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
@Schema(description = "학력")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDUCATION_ID")
	private Long id;

	@NonNull
	@Schema(description = "학교명")
	private String eduName;

	@NonNull
	@Schema(description = "시작일")
	private LocalDate eduStartDate;

	@NonNull
	@Schema(description = "종료일")
	private LocalDate eduEndDate;

	@Schema(description = "성적")
	private String eduGrade;

	@Schema(description = "전공")
	private String eduMajor;

	@Schema(description = "부전공")
	private String eduSubMajor;

	@NonNull
	@Schema(description = "고등, 대학, 대학원")
	private String eduType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	private Personal personal;
}
