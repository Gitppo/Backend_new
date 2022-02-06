package HYLikeLion.gitppo.gitppoProject.domain.personal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Setter
@Getter
@Schema(description = "자기소개")
public class Introduction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INTRO_ID")
	private Long id;

	@NonNull
	@Schema(description = "한줄 자기소개")
	private String shortIntro;

	@Schema(description = "긴 자기소개")
	private String longIntro;
}
