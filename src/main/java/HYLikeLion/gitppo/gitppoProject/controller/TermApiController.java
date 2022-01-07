package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.List;

import HYLikeLion.gitppo.gitppoProject.domain.term.Term;
import HYLikeLion.gitppo.gitppoProject.domain.term.TermAgreement;
import HYLikeLion.gitppo.gitppoProject.dto.TermDTO;
import HYLikeLion.gitppo.gitppoProject.service.TermService;
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
@RequestMapping("/api/term")
public class TermApiController {

	private final TermService termService;

	@GetMapping("/signup")
	public ResponseEntity<TermDTO.GetResult> getTerms() throws NotFoundException {
		List<Term> terms = termService.findTerms();
		HttpHeaders header = new HttpHeaders();

		TermDTO.GetResult dto = TermDTO.GetResult.builder()
			.data(terms)
			.message("OK")
			.build();

		return new ResponseEntity<>(dto, header, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<Boolean> saveAgreements(@RequestBody List<TermDTO.Post> agreements)
		throws Exception {
		List<TermAgreement> save = termService.saveTermAgreement(agreements);

		if (save.size() == 0) {
			return ResponseEntity.badRequest().build();
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
