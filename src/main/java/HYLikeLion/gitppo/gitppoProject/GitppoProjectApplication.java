package HYLikeLion.gitppo.gitppoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GitppoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitppoProjectApplication.class, args);
	}

}
