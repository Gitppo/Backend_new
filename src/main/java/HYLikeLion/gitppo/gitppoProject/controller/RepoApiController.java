package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.dto.RepoDTO;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.RepoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/repository")
public class RepoApiController {

	private final RepoService repoService;

	@Value("${external.private}")
	private String token;

	@Operation(summary = "레포지토리 조회")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "레포지토리 조회 완료", content = @Content(schema = @Schema(implementation = RepoDTO.ResponseList.class))),
	})
	@GetMapping("")
	public ResponseEntity<RepoDTO.ResponseList> getRepository(@RequestParam String githubUserName) throws Exception {

		// get the repos
		List<RepoDTO.RequestRepo> repos = repoService.getRepository(token, githubUserName);

		// get languages of repos
		List<RepoDTO.RequestRepo> repos2 = repoService.addLanguage(repos, token, githubUserName);

		// get README.md of repos
		List<RepoDTO.RequestRepo> repos3 = repoService.addReadme(repos2, token, githubUserName);

		RepoDTO.ResponseList dto = RepoDTO.ResponseList.builder()
			.status(StatusEnum.OK)
			.data(repos3)
			.message("레포 조회 완료")
			.build();
		HttpHeaders header = new HttpHeaders();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "레포지토리 저장")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "레포지토리 저장 완료", content = @Content(schema = @Schema(implementation = RepoDTO.ResponseIds.class))),
	})
	@PostMapping("")
	public ResponseEntity<RepoDTO.ResponseIds> addRepository(@RequestBody List<RepoDTO.AddRepo> body) {
		List<Long> ids = new ArrayList<>();

		for (RepoDTO.AddRepo data : body) {
			ids.add(repoService.addRepos(data));
		}

		RepoDTO.ResponseIds dto = RepoDTO.ResponseIds.builder()
			.status(StatusEnum.OK)
			.data(ids)
			.message("레포 저장 완료")
			.build();
		HttpHeaders header = new HttpHeaders();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "레포지토리 수정")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "레포지토리 수정 완료", content = @Content(schema = @Schema(implementation = RepoDTO.ResponseIds.class))),
	})
	@PutMapping("")
	public ResponseEntity<RepoDTO.ResponseIds> editRepository(@RequestBody List<RepoDTO.EditRepo> body) {
		List<Long> ids = new ArrayList<>();

		for (RepoDTO.EditRepo data : body) {
			ids.add(repoService.editRepo(data));
		}

		RepoDTO.ResponseIds dto = RepoDTO.ResponseIds.builder()
			.status(StatusEnum.OK)
			.data(ids)
			.message("레포 수정 완료")
			.build();
		HttpHeaders header = new HttpHeaders();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "레포지토리 삭제")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "레포지토리 삭제 완료", content = @Content(schema = @Schema(implementation = ResponseDTO.ResponseId.class))),
	})
	@DeleteMapping("")
	public ResponseEntity<ResponseDTO.ResponseId> deleteRepository(@Parameter(description = "Repository id", required = true, example = "1")
	@RequestParam Long id) {
		repoService.deleteRepo(id);

		ResponseDTO.ResponseId dto = ResponseDTO.ResponseId.builder()
			.id(id)
			.status(StatusEnum.OK)
			.message("레포 삭제 완료")
			.build();
		HttpHeaders header = new HttpHeaders();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}
}
