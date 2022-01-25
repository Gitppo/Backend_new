package HYLikeLion.gitppo.gitppoProject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import HYLikeLion.gitppo.gitppoProject.config.auth.LoginUser;
import HYLikeLion.gitppo.gitppoProject.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthApiController {

	private final HttpSession httpSession;

	@GetMapping("/test")
	public void login(@LoginUser SessionUser user) {
		System.out.println(user);
		// Object user = httpSession.getAttribute("user");
		// ((SessionUser)user).setCode(code);
		// System.out.println("hihi");
		// System.out.println(((SessionUser)httpSession.getAttribute("user")).getCode());
	}
}
