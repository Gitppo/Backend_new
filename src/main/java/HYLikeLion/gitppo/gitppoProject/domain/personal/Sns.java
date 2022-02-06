package HYLikeLion.gitppo.gitppoProject.domain.personal;

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
@Schema(description = "SNS")
public class Sns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SNS_ID")
	private Long id;

	@NonNull
	@Schema(description = "이름")
	private String snsName;

	@NonNull
	@Schema(description = "링크")
	private String snsLink;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	private Personal personal;
}
