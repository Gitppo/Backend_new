package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioRequestDTO;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.PortfolioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/portfolio")
public class PortfolioApiController {

	private final PortfolioService portfolioService;

	@GetMapping("")
	public ResponseEntity<PortfolioResponseDTO.GetPortfolio> getPortfolio() {
		List<Portfolio> portfolios = portfolioService.findAll();
		HttpHeaders header = new HttpHeaders();

		PortfolioResponseDTO.GetPortfolio dto = PortfolioResponseDTO.GetPortfolio.builder()
			.status(StatusEnum.OK)
			.data(portfolios)
			.message("포트폴리오 조회 완료 bb")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<PortfolioResponseDTO.AddPortfolio> addPortfolio(@RequestBody PortfolioRequestDTO.AddPortfolio requestDTO) {
		Long id = portfolioService.save(requestDTO);
		HttpHeaders header = new HttpHeaders();

		PortfolioResponseDTO.AddPortfolio dto = PortfolioResponseDTO.AddPortfolio.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 추가 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}
}
