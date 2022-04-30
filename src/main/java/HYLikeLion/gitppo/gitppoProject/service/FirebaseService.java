package HYLikeLion.gitppo.gitppoProject.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;

import HYLikeLion.gitppo.gitppoProject.domain.image.Image;
import HYLikeLion.gitppo.gitppoProject.repository.Image.ImageRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FirebaseService {

	@Value("${app.firebase-bucket}")
	private String firebaseBucket;

	private final ImageRepository imageRepository;

	@Transactional
	public void deleteImage(Image image) {
		// TODO: delete image logic
	}

	// TODO: exception 잡기
	@Transactional
	public String uploadFiles(MultipartFile file, String nameFile) throws IOException, FirebaseAuthException {
		Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
		InputStream content = new ByteArrayInputStream(file.getBytes());
		Blob blob = bucket.create(StringUtils.cleanPath(nameFile), content, file.getContentType());

		return blob.getMediaLink();
	}
}
