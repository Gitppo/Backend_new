package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
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
@Getter
@Schema(description = "기본 정보")
public class BasicInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BASICINFO_ID")
	private Long id;

	@NonNull
	@Schema(description = "이름")
	private String biName;

	@Schema(description = "메일")
	private String biMail;

	@NonNull
	@Schema(description = "생일")
	private LocalDate biBirth;

	@NonNull
	@Schema(description = "전화번호")
	private String biPhone;

	@NonNull
	@Schema(description = "이미지")
	private String biImage;
}
