package HYLikeLion.gitppo.gitppoProject.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PortfolioApiController.class)
public class PortfolioApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void 테스트용() throws Exception {
		String getPortfolio = "getPortfolio";

		mvc.perform(get("/api/portfolio"))
			.andExpect(status().isOk())
			.andExpect(content().string(getPortfolio));
	}

	@Test
	public void helloDTO가_리턴된다() throws Exception {
		String message = "test";

		mvc.perform(
			get("/api/portfolio")
		).andExpect(status().isOk())
			.andExpect(jsonPath("$.message", is(message)));
	}
}
