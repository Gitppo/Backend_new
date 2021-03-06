package HYLikeLion.gitppo.gitppoProject.config.auth;

import HYLikeLion.gitppo.gitppoProject.domain.user.Role;
import java.time.LocalDate;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import HYLikeLion.gitppo.gitppoProject.config.auth.dto.OAuthAttributes;
import HYLikeLion.gitppo.gitppoProject.config.auth.dto.SessionUser;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import HYLikeLion.gitppo.gitppoProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	private final UserRepository userRepository;
	private final HttpSession httpSession;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);

		// oauth 진행시 키가 되는 값.
		String userNameAttributeName =
			userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

		OAuthAttributes attributes = OAuthAttributes.ofGithub(userNameAttributeName,
			oAuth2User.getAttributes()); // 정보 가져옴
		User user = saveOrUpdate(attributes);  //유저값 생성

		httpSession.setAttribute("user", new SessionUser(user));    // 세션에 user 저장.

		return new DefaultOAuth2User(
			Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())), attributes.getAttributes(),
			attributes.getNameAttributeKey()
		); // oauthUser 저장.
	}

	private User saveOrUpdate(OAuthAttributes attributes) {
		User authUser = userRepository.findByGithubId(attributes.getGithubId())
			.map(entity -> entity.update(attributes.getName(), attributes.getEmail(), LocalDate.now(), Role.USER))
			.orElse(attributes.toEntity());
		;
		return userRepository.save(authUser);  // user 값 저장.
	}
}
