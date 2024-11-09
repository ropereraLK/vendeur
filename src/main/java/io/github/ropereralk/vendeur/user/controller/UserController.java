package io.github.ropereralk.vendeur.user.controller;

import io.github.ropereralk.vendeur.dto.api.UserApiDTO;
import io.github.ropereralk.vendeur.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/v1/signup")
    public ResponseEntity<String> signup(@RequestBody final UserApiDTO user) {

        System.out.println("Signup Started");
        try {
            service.createUser(user);

        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

        return ResponseEntity.status(201).body("User Creation is Successful");

    }
}
