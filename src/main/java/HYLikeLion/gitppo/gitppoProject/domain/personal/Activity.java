package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTIVITY_ID")
	private Long id;

	@NonNull
	private String actName;

	@NonNull
	private String actContents;

	@NonNull
	private LocalDate actStartDate;

	private LocalDate actEndDate;

	private String actLink;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PERSONAL_ID")
	@Getter(AccessLevel.NONE)
	private Personal personal;
}
