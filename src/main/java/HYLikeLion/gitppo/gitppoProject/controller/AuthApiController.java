package HYLikeLion.gitppo.gitppoProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import HYLikeLion.gitppo.gitppoProject.domain.OAuthToken;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import HYLikeLion.gitppo.gitppoProject.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthApiController {
    private final UserService userService;

    @Value("${github.id}")
    private String id;

    @Value("${github.secret}")
    private String secret;

    @PostMapping("/auth")
    private User getOAuthToken(@RequestParam String code) throws JsonProcessingException {
        final String tokenRequestUrl = "https://github.com/login/oauth/access_token";
        final String profileRequestUrl = "https://api.github.com/user";
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<String> response = getResponse(getCodeRequestHttpEntity(code), tokenRequestUrl, HttpMethod.POST);
        OAuthToken oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);

        ResponseEntity<String> profileResponse = getResponse(getProfileRequestEntity(oAuthToken), profileRequestUrl,
                HttpMethod.GET);
        JsonNode root = objectMapper.readTree(profileResponse.getBody());

        return userService.saveOrUpdate(root);
    }

    private HttpEntity<MultiValueMap<String, String>> getCodeRequestHttpEntity(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String REDIRECT_URL = "https://gitppo.github.io/Frontend/";

        params.add("client_id", id);
        params.add("client_secret", secret);
        params.add("code", code);
        params.add("redirect_url", REDIRECT_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        return new HttpEntity<>(params, headers);
    }

    private HttpEntity<MultiValueMap<String, String>> getProfileRequestEntity(OAuthToken oAuthToken) {
        HttpHeaders infoRequestHeaders = new HttpHeaders();
        infoRequestHeaders.add("Authorization", "token " + oAuthToken.getAccessToken());
        return new HttpEntity<>(infoRequestHeaders);
    }

    private ResponseEntity<String> getResponse(HttpEntity<MultiValueMap<String, String>> requestEntity, String url,
                                               HttpMethod httpMethod) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                url,
                httpMethod,
                requestEntity,
                String.class);
    }

}
