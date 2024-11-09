package io.github.ropereralk.vendeur.security;

import io.github.ropereralk.vendeur.login.LoginService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SecurityToken {

    @Autowired
    private LoginService loginService;

    @Value("${keycloak.cdentls.aU1}")
    private String aU1;

    @Value("${keycloak.cdentls.aP1aP1}")
    private String aP1;

    public String getAdminKeycloakToken() throws Exception{
        return  loginService.getLoginToken(aU1,aP1);
    }
}
