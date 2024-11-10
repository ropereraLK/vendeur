package io.github.ropereralk.vendeur.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.ropereralk.vendeur.dto.keycloak.UserKeycloakDTO;
import io.github.ropereralk.vendeur.security.SecurityToken;
import io.github.ropereralk.vendeur.util.validator.AccessTokenWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeycloakUserCreationSyncImpl implements KeycloakUserCreation {

    @Autowired
    private SecurityToken securityToken;

    @Autowired
    private AccessTokenWrapper accessTokenWrapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("keycloak.api.admin.createUser")
    private String createUserUrl;

    public ResponseEntity<String> createUser(UserKeycloakDTO userKeycloakDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String bearerToken = "Bearer ".concat(accessTokenWrapper.getAccessToken(securityToken.getAdminKeycloakToken()));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>( objectMapper.writeValueAsString(userKeycloakDTO), headers);

        return restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

    }
}
