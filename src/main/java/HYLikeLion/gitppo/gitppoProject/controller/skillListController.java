package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.domain.skillList.SkillContent;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.SkillListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class skillListController {
	private final SkillListService skillListService;

	@Operation(summary = "기술 스텍 리스트 조회")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "스킬 리스트 조회 완료", content = @Content(schema = @Schema(implementation = SkillContent.class))),
	})
	@GetMapping("/skillList")
	public ResponseEntity<ResponseDTO.ResponseObject> getSkillList() throws NotFoundException {
		HttpHeaders header = new HttpHeaders();
		List<SkillContent> skills = skillListService.findSkillList();

		ResponseDTO.ResponseObject dto = ResponseDTO.ResponseObject.builder()
			.status(StatusEnum.OK)
			.data(skills)
			.message("스킬 리스트 조회 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}
}
