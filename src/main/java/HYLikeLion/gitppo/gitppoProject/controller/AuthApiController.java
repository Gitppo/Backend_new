package HYLikeLion.gitppo.gitppoProject.controller;

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

    // private final String REDIRECT_URL = "http://localhost:30/00";
    private final String TOKEN_REQUEST_URL = "https://github.com/login/oauth/access_token";
    private final String PROFILE_REQUEST_URL = "https://api.github.com/user";
    private final String REDIRECT_URL = "http://gitppo.github.io/Frontend/";
    private final UserService userService;

    @PostMapping("/auth")
    private User getOAuthToken(@RequestParam String code) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(TOKEN_REQUEST_URL,
            HttpMethod.POST,
            getCodeRequestHttpEntity(code),
            String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
        System.out.println(oAuthToken);

        ResponseEntity<String> profileResponse = restTemplate.exchange(
            PROFILE_REQUEST_URL,
            HttpMethod.GET,
            getProfileRequestEntity(oAuthToken),
            String.class
        );

        JsonNode root = objectMapper.readTree(profileResponse.getBody());

        return userService.saveOrUpdate(root);
    }

    private HttpEntity<MultiValueMap<String, String>> getCodeRequestHttpEntity(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        // 주의!
        params.add("client_id", "93ad6f9f68a2f8fbd473");
        params.add("client_secret", "b548d698a91c1057736919d1fc12555f1443b24c");
        params.add("code", code);
        params.add("redirect_url", REDIRECT_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        return new HttpEntity<>(params, headers);
    }

    private HttpEntity<MultiValueMap<String, String>> getProfileRequestEntity(
        OAuthToken oAuthToken) {
        HttpHeaders infoRequestHeaders = new HttpHeaders();
        infoRequestHeaders.add("Authorization", "token " + oAuthToken.getAccessToken());
        return new HttpEntity<>(infoRequestHeaders);
    }

}
