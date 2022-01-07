package HYLikeLion.gitppo.gitppoProject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import HYLikeLion.gitppo.gitppoProject.domain.term.Term;
import HYLikeLion.gitppo.gitppoProject.domain.term.TermAgreement;
import HYLikeLion.gitppo.gitppoProject.dto.TermDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Term.TermAgreementRepository;
import HYLikeLion.gitppo.gitppoProject.repository.Term.TermRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TermService {

	private final TermRepository termRepository;
	private final TermAgreementRepository termAgreementRepository;

	public List<TermAgreement> saveTermAgreement(List<TermDTO.Post> agreements) throws Exception {
		List<TermAgreement> result = new ArrayList<>();

		if (agreements.size() == 0) {
			throw new Exception("Size of agreements can't be 0");
		}

		for (TermDTO.Post agreement : agreements) {
			Term term = termRepository.findById(agreement.getTermID())
				.orElseThrow(() -> new NotFoundException(
					"Term with id : " + agreement.getTermID() + "is not valid"));

			TermAgreement termAgreement = TermAgreement.builder()
				.term(term)
				.agreeDate(LocalDateTime.now())
				.isAgree(agreement.getTermAgreementIsAgree())
				.build();
			termAgreementRepository.save(termAgreement);

			result.add(termAgreement);
		}
		return result;
	}

	public List<Term> findTerms() {
		return termRepository.findAll();
	}

}
