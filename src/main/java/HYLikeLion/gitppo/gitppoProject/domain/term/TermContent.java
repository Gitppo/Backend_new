package HYLikeLion.gitppo.gitppoProject.domain.term;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Schema(description = "이용 약관 내용")
public class TermContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TERM_CONTENT_ID")
	private Long id;

	@NonNull
	@Getter
	@Schema(description = "약관 제목")
	private String title;

	@NonNull
	@Getter
	@Schema(description = "약관 내용")
	private String contents;

	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TERM_ID")
	private Term term;

}
