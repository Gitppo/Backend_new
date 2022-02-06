package HYLikeLion.gitppo.gitppoProject.domain.skillList;

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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Setter
@Getter
@Schema(description = "기술 스택_ 리스트")
public class SkillContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKILL_ID")
	private Long id;

	@NonNull
	@Schema(description = "이름")
	private String name;
}
