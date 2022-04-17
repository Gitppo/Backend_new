package HYLikeLion.gitppo.gitppoProject.controller;

import HYLikeLion.gitppo.gitppoProject.domain.term.Term;
import HYLikeLion.gitppo.gitppoProject.domain.term.TermAgreement;
import HYLikeLion.gitppo.gitppoProject.dto.TermDTO;
import HYLikeLion.gitppo.gitppoProject.service.TermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TermApiController {

	private final TermService termService;

	@Operation(summary = "약관 조회")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "약관 조회 완료", content = @Content(schema = @Schema(implementation = TermDTO.GetResult.class))),
	})
	@GetMapping("/term")
	public ResponseEntity<TermDTO.GetResult> getTerms(){
		List<Term> terms = termService.findTerms();
		HttpHeaders header = new HttpHeaders();

		TermDTO.GetResult dto = TermDTO.GetResult.builder()
			.data(terms)
			.message("약관 조회 완료")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@Operation(summary = "약관 동의 저장")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "약관 동의 저장 완료"),
	})
	@PostMapping("/term")
	public ResponseEntity<Boolean> saveAgreements(@RequestBody List<TermDTO.Post> agreements)
		throws Exception {
		List<TermAgreement> save = termService.saveTermAgreement(agreements);

		if (save.size() == 0) {
			return ResponseEntity.badRequest().build();
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
