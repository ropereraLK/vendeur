package io.github.ropereralk.vendeur.dto.keycloak;

import org.springframework.stereotype.Component;

import java.util.List;


public class UserKeycloakDTO {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private List<CredentialsKeycloakDTO> credentials;

    public UserKeycloakDTO(String username, String email, String firstName, String lastName, boolean enabled, List<CredentialsKeycloakDTO> credentials) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.credentials = credentials;
    }

    public UserKeycloakDTO() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCredentials(List<CredentialsKeycloakDTO> credentials) {
        this.credentials = credentials;
    }



}
