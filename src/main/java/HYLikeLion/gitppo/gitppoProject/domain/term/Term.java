package HYLikeLion.gitppo.gitppoProject.domain.term;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Schema(description = "이용약관")
public class Term {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TERM_ID")
	private Long id;

	@NonNull
	@Schema(description = "약관 제목")
	private String termTitle;

	@OneToMany(mappedBy = "term")
	@Schema(description = "약관 내용")
	private List<TermContent> contents;

	@Column(nullable = false, columnDefinition = "tinyint default 0")
	@Schema(description = "약관 필수 여부", defaultValue = "0")
	boolean isRequired = true;
}
