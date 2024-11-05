package io.github.ropereralk.vendeur.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String getLoginToken(String u1, String p1) {

        return "MyToken";
        //Call Keycloak
    }
}
