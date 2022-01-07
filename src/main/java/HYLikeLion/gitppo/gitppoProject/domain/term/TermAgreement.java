package HYLikeLion.gitppo.gitppoProject.domain.term;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
public class TermAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TERM_AG_ID")
	private Long id;

	//    유저는 아직 안만들어져서 일단 없는 상태로 해놓음.
	//    @OneToOne
	//    @NonNull
	//    private User user_id;

	@OneToOne
	@NonNull
	@JoinColumn(name = "TERM_ID")
	private Term term;

	@NonNull
	private LocalDateTime agreeDate;

	@NonNull
	@Column(nullable = false, columnDefinition = "tinyint default 1")
	private Boolean isAgree;

	@Builder
	public TermAgreement(@NonNull Term term, @NonNull LocalDateTime agreeDate, @NonNull Boolean isAgree) {
		this.term = term;
		this.agreeDate = agreeDate;
		this.isAgree = isAgree;
	}
}
