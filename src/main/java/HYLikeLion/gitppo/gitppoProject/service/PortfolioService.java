package HYLikeLion.gitppo.gitppoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.domain.repo.Repo;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import HYLikeLion.gitppo.gitppoProject.dto.PortfolioDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Portfolio.PortfolioRepository;
import HYLikeLion.gitppo.gitppoProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PortfolioService {

	private final PortfolioRepository portfolioRepository;
	private final UserRepository userRepository;

	@Transactional
	public List<Portfolio> findByUser(User user) {
		return portfolioRepository.findByUser(user);
	}

	@Transactional
	public Long save(PortfolioDTO.AddPortfolio requestDTO) {
		User user = userRepository.findById(requestDTO.getUsrId())
			.orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + requestDTO.getUsrId()));

		Portfolio portfolio = Portfolio.builder()
			.user(user)
			.pfTmpSave(true)
			.pfShare(false)
			.pfName(requestDTO.getPfName())
			.pfTemplate(0)
			.pfStar(requestDTO.getPfStar())
			.pfUuid(UUID.randomUUID().toString())
			.build();

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
			.createdDate(portfolio.getCreatedDate())
			.modifiedDate(portfolio.getModifiedDate())
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
			.modifiedDate(portfolio.getModifiedDate())
			.createdDate(portfolio.getCreatedDate())
			.build();
	}

	@Transactional
	public void deletePortfolio(Long id) {
		portfolioRepository.deleteById(id);
	}
}
