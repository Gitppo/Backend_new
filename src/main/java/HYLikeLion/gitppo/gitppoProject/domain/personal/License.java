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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Schema(description = "자격증")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LICENSE_ID")
	private Long id;

	@NonNull
	@Schema(description = "이름")
	private String licName;

	@NonNull
	@Schema(description = "취득일")
	private LocalDate licDate;

	@NonNull
	@Schema(description = "발급기관")
	private String licOrganization;

	@NonNull
	@Schema(description = "등급레벨급수")
	private String licLevel;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	private Personal personal;
}
