package HYLikeLion.gitppo.gitppoProject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import HYLikeLion.gitppo.gitppoProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public User findById(Long id) {
		 Optional<User> optUser = userRepository.findById(id);

		 return optUser.orElseThrow(() -> new NullPointerException("해당 id의 유저가 존재하지 않습니다."));
	}
}
