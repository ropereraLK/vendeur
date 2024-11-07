package io.github.ropereralk.vendeur.login;

import io.github.ropereralk.vendeur.configurations.WebClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@Service
public class LoginAsyncService {

    @Autowired
    private WebClientConfiguration webClientConfiguration;

    @Value("${keycloak.tokenUrl}")
    private String t1Url;

    @Value("${keycloak.clientId}")
    private String clientId;

    public Mono<String> getLoginToken(String u1, String p1) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("username", u1);
        formData.add("password", p1);
        formData.add("client_id", clientId);

        return webClientConfiguration.webClientBuilder().baseUrl(t1Url)
                .build()
                .post()
                .header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(String.class);

    }

}
