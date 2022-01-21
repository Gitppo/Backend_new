package HYLikeLion.gitppo.gitppoProject.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import HYLikeLion.gitppo.gitppoProject.dto.RepoDTO;
import HYLikeLion.gitppo.gitppoProject.repository.Repo.RepoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RepoService {

	private final RepoRepository repoRepository;

	@Transactional
	public List<RepoDTO.RequestRepo> getRepository(String name) throws Exception {
		// set header
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		// set header and params in HttpEntity
		HttpEntity entity = new HttpEntity(httpHeaders);

		// request through url
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<RepoDTO.RequestRepo>> responseEntity = restTemplate.exchange("https://api.github.com/users/" + name + "/repos", HttpMethod.GET, entity, new ParameterizedTypeReference<List<RepoDTO.RequestRepo>>() {});
		List<RepoDTO.RequestRepo> list = responseEntity.getBody();

		return list;
	}

	@Transactional
	public List<RepoDTO.RequestRepo> addLanguage(List<RepoDTO.RequestRepo> repos, String name) throws Exception {
		// set header
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		// set header and params in HttpEntity
		HttpEntity entity = new HttpEntity(httpHeaders);

		for (RepoDTO.RequestRepo repo : repos) {
			// request through url
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map<String, Long>> responseEntity = restTemplate.exchange("https://api.github.com/repos/" + name + "/" + repo.getName() + "/languages", HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Long>>() {});
			repo.setLanguages(responseEntity.getBody());
		}

		return repos;
	}

	@Transactional
	public List<RepoDTO.RequestRepo> addReadme(List<RepoDTO.RequestRepo> repos, String name) throws Exception {
		// set header
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		// set header and params in HttpEntity
		HttpEntity entity = new HttpEntity(httpHeaders);

		for (RepoDTO.RequestRepo repo : repos) {
			// TODO: get default branch

			// TODO: get README.md file of default branch

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map<String, Long>> responseEntity = restTemplate.exchange("https://api.github.com/repos/" + name + "/" + repo.getName() + "/languages", HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Long>>() {});
			repo.setLanguages(responseEntity.getBody());
		}

		return repos;
	}
}
