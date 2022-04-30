package HYLikeLion.gitppo.gitppoProject.config.firebase;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

	@Value("${app.firebase-configuration-file}")
	private String firebaseConfigPath;

	@PostConstruct
	public void initialize() {
		try {
			FirebaseOptions options = FirebaseOptions
				.builder()
				.setCredentials(GoogleCredentials.fromStream(
				new ClassPathResource(firebaseConfigPath).getInputStream()
				)).build();

			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
				// TODO: 로그 처리 필요
				System.out.println("Firebase application has been initialized");
			}
		} catch (Exception e) {
			// TODO: 나중에 처리
			System.out.println(e.getMessage());
		}
	}
}
