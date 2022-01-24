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

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BasicInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BASICINFO_ID")
	private Long id;

	@NonNull
	private String biName;

	private String biMail;

	@NonNull
	private LocalDate biBirth;

	@NonNull
	private String biPhone;

	@NonNull
	private String biImage;
}
