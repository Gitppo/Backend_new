package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.Port;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.config.auth.LoginUser;
import HYLikeLion.gitppo.gitppoProject.config.auth.dto.SessionUser;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioDTO;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.PortfolioService;
import HYLikeLion.gitppo.gitppoProject.service.RepoService;
import HYLikeLion.gitppo.gitppoProject.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/portfolio")
public class PortfolioApiController {

	private final UserService userService;
	private final PortfolioService portfolioService;

	@GetMapping("")
	public ResponseEntity<PortfolioDTO.ResponseList> getPortfolio(@LoginUser SessionUser user) {
		List<Portfolio> portfolios = portfolioService.findByUser(userService.findById(user.getId()));
		HttpHeaders header = new HttpHeaders();

		List<PortfolioDTO.GetPortfolio> data = new ArrayList<>();
		for (Portfolio p : portfolios) {
			data.add(PortfolioDTO.GetPortfolio.from(p));
		}

		PortfolioDTO.ResponseList dto = PortfolioDTO.ResponseList.builder()
			.status(StatusEnum.OK)
			.data(data)
			.message("포트폴리오 조회 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<ResponseDTO.ResponseId> addPortfolio(@RequestBody PortfolioDTO.AddPortfolio requestDTO, @LoginUser SessionUser user) {
		Long id = portfolioService.save(userService.findById(user.getId()), requestDTO);
		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseId dto = ResponseDTO.ResponseId.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 추가 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@PostMapping("/complete")
	public ResponseEntity<ResponseDTO.ResponseId> saveCompletelyPortfolio(@RequestBody PortfolioDTO.SavePortfolio requestDTO, @LoginUser SessionUser user) {
		Long id = portfolioService.saveCompletely(requestDTO);
		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseId dto = ResponseDTO.ResponseId.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 저장 및 템플릿 저장 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

}
