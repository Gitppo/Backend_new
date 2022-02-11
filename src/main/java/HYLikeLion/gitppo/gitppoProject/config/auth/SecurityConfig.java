package HYLikeLion.gitppo.gitppoProject.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import HYLikeLion.gitppo.gitppoProject.domain.user.Role;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().and() // cors 허용

			.csrf().disable()
			.headers().frameOptions().disable().and()  // h2용도
			.authorizeRequests()// url별 권한 설정.
			.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/login/**", "/test/**",
				"/swagger-ui/**", "/swagger-resources/**", "/api/term", "/v3/api-docs", "/api/portfolio/lookup/**").permitAll()
			.antMatchers("/api/**").hasRole(Role.USER.name())
			.anyRequest().authenticated().and()

			.logout()
			.logoutSuccessUrl("/").and()

			.oauth2Login()
			.userInfoEndpoint()
			.userService(customOAuth2UserService);   //로그인 이후 진행되는 서비스 파일.
	}

	// @Bean
	// public CorsConfigurationSource corsConfigurationSource() {
	// 	CorsConfiguration configuration = new CorsConfiguration();
	//
	// 	configuration.addAllowedOrigin("*");
	// 	configuration.addAllowedHeader("*");
	// 	configuration.addAllowedMethod("*");
	// 	configuration.setAllowCredentials(true);
	//
	// 	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	// 	source.registerCorsConfiguration("/**", configuration);
	// 	return source;
	// }
}
