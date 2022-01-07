package HYLikeLion.gitppo.gitppoProject.domain.term;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class TermContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TERM_CONTENT_ID")
	private Long id;

	@NonNull
	@Getter
	private String title;

	@NonNull
	@Getter
	private String contents;

	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TERM_ID")
	private Term term;

}
