package HYLikeLion.gitppo.gitppoProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioRequestDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Portfolio.PortfolioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PortfolioService {
	private final PortfolioRepository portfolioRepository;

	@Transactional
	public List<Portfolio> findAll() {
		return portfolioRepository.findAll();
	}

	@Transactional
	public Long save(PortfolioRequestDTO.AddPortfolio requestDTO) {
		return portfolioRepository.save(requestDTO.toEntity()).getId();
	}
}
