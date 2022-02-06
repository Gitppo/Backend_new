package HYLikeLion.gitppo.gitppoProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.domain.repo.Repo;
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
	public Long editPortfolio(PortfolioDTO.EditPortfolio data) {
		Portfolio portfolio = portfolioRepository.findById(data.getId())
			.orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. id=" + data.getId()));

		portfolio.update(data.getPfName(), data.getPfStar());

		return data.getId();
	}

	@Transactional
	public Long saveCompletely(PortfolioDTO.SavePortfolio data) {
		Portfolio portfolio = portfolioRepository.findById(data.getPfId())
			.orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. id=" + data.getPfId()));

		portfolio.saveCompletely(data.getPfTemplate(), false, data.getPfShare());

		return data.getPfId();
	}

	@Transactional
	public PortfolioDTO.GetAllPortfolio findById(Long id) {
		System.out.println(id);
		Portfolio portfolio = portfolioRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. id=" + id));

		return PortfolioDTO.GetAllPortfolio.builder()
			.id(portfolio.getId())
			.usrId(portfolio.getUser().getId())
			.pfName(portfolio.getPfName())
			.pfTmpSave(portfolio.getPfTmpSave())
			.pfStar(portfolio.getPfStar())
			.pfUuid(portfolio.getPfUuid())
			.pfTemplate(portfolio.getPfTemplate())
			.personal(portfolio.getPersonal())
			.repo(portfolio.getRepo())
			.pfShare(portfolio.getPfShare())
			.build();
	}

	@Transactional
	public PortfolioDTO.GetAllPortfolio findByUuid(String uuid) {
		Portfolio portfolio = portfolioRepository.findByPfUuid(uuid);

		return PortfolioDTO.GetAllPortfolio.builder()
			.id(portfolio.getId())
			.usrId(portfolio.getUser().getId())
			.pfName(portfolio.getPfName())
			.pfTmpSave(portfolio.getPfTmpSave())
			.pfStar(portfolio.getPfStar())
			.pfUuid(portfolio.getPfUuid())
			.pfTemplate(portfolio.getPfTemplate())
			.personal(portfolio.getPersonal())
			.repo(portfolio.getRepo())
			.pfShare(portfolio.getPfShare())
			.build();
	}

	@Transactional
	public PortfolioDTO.GetAllPortfolio findByUuid(String pfUuid) {
		Portfolio portfolio = portfolioRepository.findByPfUuid(pfUuid)
			.orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다. uuid=" + pfUuid));

		return PortfolioDTO.GetAllPortfolio.builder()
			.id(portfolio.getId())
			.usrId(portfolio.getUser().getId())
			.pfName(portfolio.getPfName())
			.pfTmpSave(portfolio.getPfTmpSave())
			.pfStar(portfolio.getPfStar())
			.pfUuid(portfolio.getPfUuid())
			.pfTemplate(portfolio.getPfTemplate())
			.personal(portfolio.getPersonal())
			.repo(portfolio.getRepo())
			.build();
	}

	@Transactional
	public void deletePortfolio(Long id) {
		portfolioRepository.deleteById(id);
	}
}
