package HYLikeLion.gitppo.gitppoProject.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;

import HYLikeLion.gitppo.gitppoProject.domain.user.Role;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import HYLikeLion.gitppo.gitppoProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 존재하지 않습니다. id = " + id));
    }

    @Transactional
    public User saveOrUpdate(JsonNode root) {
        User authUser = userRepository.findByGithubId(root.path("id").asLong())
                .map(entity -> entity.update(root.path("name").asText(), root.path("email").asText(),
                        LocalDate.now(), Role.USER))
                .orElse(User.builder()
                        .name(root.path("name").asText())
                        .githubId(root.path("id").asLong())
                        .githubUserName(root.path("login").asText())
                        .email(root.path("email").asText())
                        .joinDate(LocalDate.now())
                        .loginDate(LocalDate.now())
                        .role(Role.FIRST)
                        .build());

        return userRepository.save(authUser);
    }
}
