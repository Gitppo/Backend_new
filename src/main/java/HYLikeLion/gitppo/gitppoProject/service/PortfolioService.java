package HYLikeLion.gitppo.gitppoProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HYLikeLion.gitppo.gitppoProject.dto.PortfolioRequestDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Portfolio.PortfolioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PortfolioService {
	private final PortfolioRepository portfolioRepository;

	@Transactional
	public Long save(PortfolioRequestDTO.AddPortfolio requestDTO) {
		return portfolioRepository.save(requestDTO.toEntity()).getId();
	}
}
