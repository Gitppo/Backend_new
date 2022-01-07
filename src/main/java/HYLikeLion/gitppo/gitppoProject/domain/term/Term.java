package HYLikeLion.gitppo.gitppoProject.domain.term;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Term {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TERM_ID")
	private Long id;

	@NonNull
	private String termTitle;

	@OneToMany(mappedBy = "term")
	private List<TermContent> contents;

	@Column(nullable = false, columnDefinition = "tinyint default 0")
	boolean isRequired = true;
}
