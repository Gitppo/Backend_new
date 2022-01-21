package HYLikeLion.gitppo.gitppoProject.domain.Repo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Repo {

	@Id
	private Long id;

}
