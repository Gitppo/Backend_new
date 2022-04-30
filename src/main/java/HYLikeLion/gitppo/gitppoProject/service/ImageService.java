package HYLikeLion.gitppo.gitppoProject.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.firebase.auth.FirebaseAuthException;

import HYLikeLion.gitppo.gitppoProject.domain.image.Image;
import HYLikeLion.gitppo.gitppoProject.repository.Image.ImageRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {

	private final ImageRepository imageRepository;
	private final FirebaseService firebaseService;
	private final UserService userService;

	@Transactional
	public Image save(MultipartFile image, Long id) throws IOException, FirebaseAuthException {
		Long githubId = userService.findById(id).getGithubId();
		LocalDateTime now = LocalDateTime.now();
		String type = image.getContentType().split("/")[image.getContentType().split("/").length - 1];
		String fileName = now.format(DateTimeFormatter.ofPattern("yyyymmddHHmmss")) + "-" + githubId + "." + type;
		String imageUrl = firebaseService.uploadFiles(image, fileName);
		Image imageObj = Image.builder()
		    .imgName(image.getOriginalFilename())
		    .imgUrl(imageUrl)
		    .build();

		imageRepository.save(imageObj);

		return imageObj;
	}
}
