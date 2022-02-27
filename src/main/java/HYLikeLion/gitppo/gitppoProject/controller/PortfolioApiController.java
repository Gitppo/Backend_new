package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
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

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioDTO;
import HYLikeLion.gitppo.gitppoProject.dto.RepoDTO;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.PortfolioService;
import HYLikeLion.gitppo.gitppoProject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/portfolio")
public class PortfolioApiController {

	private final UserService userService;
	private final PortfolioService portfolioService;

	@Operation(summary = "포트폴리오 조회")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 조회 완료", content = @Content(schema = @Schema(implementation = RepoDTO.ResponseList.class))),
	})
	@GetMapping("")
	public ResponseEntity<PortfolioDTO.ResponseList> getPortfolio(@RequestParam Long id) {
		List<Portfolio> portfolios = portfolioService.findByUser(userService.findById(id));
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

	@Operation(summary = "포트폴리오 추가")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 추가 완료", content = @Content(schema = @Schema(implementation = ResponseDTO.ResponseId.class))),
	})
	@PostMapping("")
	public ResponseEntity<ResponseDTO.ResponseId> addPortfolio(@RequestBody PortfolioDTO.AddPortfolio requestDTO) {
		Long id = portfolioService.save(requestDTO);
		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseId dto = ResponseDTO.ResponseId.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 추가 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "포트폴리오 제목, 스타 여부 수정")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 수정 완료", content = @Content(schema = @Schema(implementation = ResponseDTO.ResponseId.class))),
	})
	@PutMapping("")
	public ResponseEntity<ResponseDTO.ResponseId> editPortfolio(@RequestBody PortfolioDTO.EditPortfolio requestDTO) {
		Long id = portfolioService.editPortfolio(requestDTO);
		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseId dto = ResponseDTO.ResponseId.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 수정 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "포트폴리오 임시저장 -> 저장 & 템플릿 저장")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 저장 및 템플릿 저장 완료", content = @Content(schema = @Schema(implementation = ResponseDTO.ResponseId.class))),
	})
	@PostMapping("/complete")
	public ResponseEntity<ResponseDTO.ResponseId> saveCompletelyPortfolio(
		@RequestBody PortfolioDTO.SavePortfolio requestDTO) {
		Long id = portfolioService.saveCompletely(requestDTO);
		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseId dto = ResponseDTO.ResponseId.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 저장 및 템플릿 저장 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "포트폴리오 id로 조회")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 조회 완료", content = @Content(schema = @Schema(implementation = Portfolio.class))),
	})
	@GetMapping("/all")
	public ResponseEntity<PortfolioDTO.ResponsePortfolio> getAllPortfolio(@Param("id") Long id) {
		PortfolioDTO.GetAllPortfolio portfolio = portfolioService.findById(id);
		HttpHeaders header = new HttpHeaders();

		PortfolioDTO.ResponsePortfolio dto = PortfolioDTO.ResponsePortfolio.builder()
			.status(StatusEnum.OK)
			.data(portfolio)
			.message("포트폴리오 조회 완료 id=" + id)
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "공유된 포트폴리오 조회")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 조회 완료", content = @Content(schema = @Schema(implementation = RepoDTO.ResponseList.class))),
	})
	@GetMapping("/lookup")
	public ResponseEntity<PortfolioDTO.ResponsePortfolio> getPortfolio(@RequestParam String uuid) {
		PortfolioDTO.GetAllPortfolio portfolio = portfolioService.findByUuid(uuid);
		HttpHeaders header = new HttpHeaders();

		PortfolioDTO.ResponsePortfolio result;

		if (portfolio == null || !portfolio.getPfShare()) {
			result = PortfolioDTO.ResponsePortfolio.builder()
				.status(StatusEnum.NOT_FOUND)
				.data(null)
				.message("포트폴리오 조회 실패")
				.build();
			return new ResponseEntity<>(result, header, HttpStatus.NOT_FOUND);
		}

		result = PortfolioDTO.ResponsePortfolio.builder()
			.status(StatusEnum.OK)
			.data(portfolio)
			.message("포트폴리오 조회 완료")
			.build();
		return new ResponseEntity<>(result, header, HttpStatus.OK);
	}
  
	@Operation(summary = "포트폴리오 삭제")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "포트폴리오 삭제 완료"),
	})
	@DeleteMapping("")
	public ResponseEntity<ResponseDTO.ResponseId> deletePortfolio(
		@Parameter(description = "Portfolio id", required = true, example = "1")
		@RequestParam Long id) {
		portfolioService.deletePortfolio(id);

		HttpHeaders header = new HttpHeaders();

		ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
			.status(StatusEnum.OK)
			.id(id)
			.message("포트폴리오 삭제 완료")
			.build();

		return new ResponseEntity<>(response, header, HttpStatus.OK);
	}
}
