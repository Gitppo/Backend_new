package HYLikeLion.gitppo.gitppoProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Portfolio.PortfolioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PortfolioService {

	private final PortfolioRepository portfolioRepository;

	@Transactional
	public List<Portfolio> findByUser(User user) {
		return portfolioRepository.findByUser(user);
	}

	@Transactional
	public Long save(User user, PortfolioDTO.AddPortfolio requestDTO) {
		Portfolio portfolio = requestDTO.toEntity();
		portfolio.setUser(user);

		return portfolioRepository.save(portfolio).getId();
	}

	@Transactional
	public Long saveCompletely(PortfolioDTO.SavePortfolio data) {
		Portfolio portfolio = portfolioRepository.getById(data.getPfId());

		portfolio.saveCompletely(data.getPfTemplate(), false);

		return data.getPfId();
	}
}
