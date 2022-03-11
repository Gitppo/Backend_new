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
@Getter
@Schema(description = "출판,논문,특허")
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ppCATION_ID")
	private Long id;

	@NonNull
	@Schema(description = "이름")
	private String ppName;

	@Schema(description = "고유번호, 출원번호")
	private String ppNumber;

	@Schema(description = "출판사, 출원국가")
	private String ppPublisher;

	@Schema(description = "저자")
	private String ppWriter;

	@NonNull
	@Schema(description = "출판일")
	private LocalDate ppDate;

	@Schema(description = "내용")
	private String ppContents;

	@Schema(description = "링크")
	private String ppLink;

	@ManyToOne
	@JoinColumn(name="PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	@Setter
	private Personal personal;

}
