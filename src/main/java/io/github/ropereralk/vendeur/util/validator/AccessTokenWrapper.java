package io.github.ropereralk.vendeur.util.validator;

import io.github.ropereralk.vendeur.AccessTokenNotFoundException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenWrapper {

    public String getAccessToken(String v1) throws AccessTokenNotFoundException, Exception {

        JSONObject j1 = new JSONObject(v1);
        String accessToken = j1.get("access_token").toString();

        if (accessToken.isEmpty()) {
            throw new AccessTokenNotFoundException();
        }
        return accessToken;
    }

}
