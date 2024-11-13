package io.github.ropereralk.vendeur.user.service;

import io.github.ropereralk.vendeur.dto.keycloak.UserKeycloakDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class KeycloakUserCreationAsyncImpl {

    @Autowired
    private WebClient keycloakWebClient;

    public void createUser(){

    }

    Mono<UserKeycloakDTO> userMono;

    Mono<Void> result = keycloakWebClient.post()
            .uri("")
            .contentType(MediaType.APPLICATION_JSON)
            .body(userMono, UserKeycloakDTO.class)
            .retrieve()
            .bodyToMono(Void.class);
}
