package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.config.auth.LoginUser;
import HYLikeLion.gitppo.gitppoProject.config.auth.dto.SessionUser;
import HYLikeLion.gitppo.gitppoProject.dto.RepoDTO;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.RepoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/repository")
public class RepoApiController {

	private final RepoService repoService;

	@GetMapping("")
	public ResponseEntity<ResponseDTO.ResponseList> getRepository(@LoginUser SessionUser user) throws Exception {
		// get the repos
		List<RepoDTO.RequestRepo> repos = repoService.getRepository(user.getName());

		// get languages of repos
		List<RepoDTO.RequestRepo> repos2 = repoService.addLanguage(repos, user.getName());

		// get README.md of repos
		List<RepoDTO.RequestRepo> repos3 = repoService.addReadme(repos2, user.getName());

		ResponseDTO.ResponseList dto = ResponseDTO.ResponseList.builder()
			.status(StatusEnum.OK)
			.data(Collections.singletonList(repos3))
			.message("레포 조회 완료")
			.build();
		HttpHeaders header = new HttpHeaders();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}
}
