package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Introduction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INTRO_ID")
	private Long id;

	@NonNull
	private String shortIntro;

	private String longIntro;
}
