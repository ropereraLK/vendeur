package io.github.ropereralk.vendeur.user.controller;

import io.github.ropereralk.vendeur.dto.api.UserApiDTO;
import io.github.ropereralk.vendeur.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import java.net.http.HttpResponse;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/users")
    public boolean createUser(UserApiDTO user){

        HttpResponse response = service.createUser(user);
        return true;
    }
}
