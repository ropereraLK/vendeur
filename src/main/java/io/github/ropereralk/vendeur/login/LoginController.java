package io.github.ropereralk.vendeur.login;

import io.github.ropereralk.vendeur.dto.api.LoginRequestApiDTO;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> authUser(@Valid @RequestBody LoginRequestApiDTO loginRequestApiDTO){

        return ResponseEntity.ok(loginService.getLoginToken(
                StringEscapeUtils.escapeHtml4(loginRequestApiDTO.getU1()),
                StringEscapeUtils.escapeHtml4(loginRequestApiDTO.getP1())));
    }
}
