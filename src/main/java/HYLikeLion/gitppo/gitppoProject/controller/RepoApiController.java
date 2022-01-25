package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.config.auth.LoginUser;
import HYLikeLion.gitppo.gitppoProject.config.auth.dto.SessionUser;
import HYLikeLion.gitppo.gitppoProject.dto.RepoDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.RepoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/repository")
public class RepoApiController {

	private final RepoService repoService;

	@Value("${external.private}")
	private String token;

	@GetMapping("")
	public ResponseEntity<RepoDTO.ResponseList> getRepository(@LoginUser SessionUser user) throws Exception {

		// get the repos
		List<RepoDTO.RequestRepo> repos = repoService.getRepository(token, user.getName());

		// get languages of repos
		List<RepoDTO.RequestRepo> repos2 = repoService.addLanguage(repos, token, user.getName());

		// get README.md of repos
		List<RepoDTO.RequestRepo> repos3 = repoService.addReadme(repos2, token, user.getName());

		RepoDTO.ResponseList dto = RepoDTO.ResponseList.builder()
			.status(StatusEnum.OK)
			.data(repos3)
			.message("레포 조회 완료")
			.build();
		HttpHeaders header = new HttpHeaders();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<RepoDTO.ResponseIds> addRepository(@RequestBody List<RepoDTO.AddRepo> body, @LoginUser SessionUser user) {
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
}
