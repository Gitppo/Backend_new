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
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDUCATION_ID")
	private Long id;

	@NonNull
	private String eduName;  // 학교명

	@NonNull
	private String eduDepartmentName;

	@NonNull
	private LocalDate eduStartDate;

	@NonNull
	private LocalDate eduEndDate;

	private String eduGrade;

	private String eduMajor;

	private String eduSubMajor;

	@NonNull
	private String eduType;   // 고등, 대학, 대학원

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	private Personal personal;
}
