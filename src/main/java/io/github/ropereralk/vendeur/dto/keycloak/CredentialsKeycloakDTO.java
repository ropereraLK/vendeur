package io.github.ropereralk.vendeur.dto.keycloak;

public class CredentialsKeycloakDTO {

    private String type;
    private String value;
    private boolean temporary;

    public CredentialsKeycloakDTO(String type, String value, boolean temporary) {
        this.type = type;
        this.value = value;
        this.temporary = temporary;
    }

    public CredentialsKeycloakDTO() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }
}
