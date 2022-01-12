package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HYLikeLion.gitppo.gitppoProject.domain.term.Portfolio;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.dto.TermDTO;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioApiController {

	@GetMapping("")
	public ResponseEntity<PortfolioDTO.GetPortfolio> getPortfolio() {
		List<Portfolio> portfolios = new ArrayList<>();
		HttpHeaders header = new HttpHeaders();

		PortfolioDTO.GetPortfolio dto = PortfolioDTO.GetPortfolio.builder()
			.status(StatusEnum.OK)
			.data(portfolios)
			.message("OK")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}
}
