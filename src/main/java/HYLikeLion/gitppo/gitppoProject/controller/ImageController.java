package HYLikeLion.gitppo.gitppoProject.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import HYLikeLion.gitppo.gitppoProject.domain.image.Image;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class ImageController {

	private final ImageService imageService;

	@Operation(summary = "이미지 저장")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "이미지 저장 완료", content = @Content(schema = @Schema(implementation = ResponseDTO.ResponseObject.class))),
	})
	@PostMapping("image")
	public ResponseEntity<ResponseDTO.ResponseObject> saveImage(
		@RequestParam("image") MultipartFile image,
		@RequestParam("usrId") Long id) throws Exception {

		Image imageObj = imageService.save(image, id);
		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseObject dto = ResponseDTO.ResponseObject.builder()
			.status(StatusEnum.OK)
			.data(imageObj)
			.message("이미지 추가 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}
}
