package io.github.ropereralk.vendeur.user.service;

import io.github.ropereralk.vendeur.dto.api.UserApiDTO;
import io.github.ropereralk.vendeur.dto.mongo.UserDTO;
import io.github.ropereralk.vendeur.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserDTO user;

    UserRepository userRepository;

    public HttpResponse createUser(final UserApiDTO userApi) {

        /**
         * 01: Create User in Keycloak
         */

        /**
         * 02: Create User in Mongodb
         */

        //Transform
        transform(userApi);

        userRepository.save(user);
        return null;
    }

    private UserDTO transform(UserApiDTO userApiDTO){

        user.setUserId(UUID.randomUUID());
        user.setFirstName(userApiDTO.getFirstName());
        user.setLastName(userApiDTO.getLastName());
        user.setEmail(userApiDTO.getEmail());
        user.setActive(false);
        return null;
    }


}
