package HYLikeLion.gitppo.gitppoProject.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import HYLikeLion.gitppo.gitppoProject.domain.user.Role;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().disable().and()  // h2용도
			.authorizeRequests()// url별 권한 설정.
			.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/login/**", "/test/**",
				"/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs").permitAll()
			.antMatchers("/api/**").hasRole(Role.USER.name())
			.anyRequest().authenticated()

			.and()
			.logout()
			.logoutSuccessUrl("/")

			.and()
			.oauth2Login()
			.userInfoEndpoint()
			.userService(customOAuth2UserService);   //로그인 이후 진행되는 서비스 파일.
	}
}
