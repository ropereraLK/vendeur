package io.github.ropereralk.vendeur.user.service;

import io.github.ropereralk.vendeur.dto.api.UserApiDTO;
import io.github.ropereralk.vendeur.dto.mongo.UserDTO;
import io.github.ropereralk.vendeur.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Service
public class UserService {

    UserDTO user = new UserDTO();

    @Autowired
    UserRepository userRepository;

    public boolean createUser(final UserApiDTO userApi) throws Exception {

        /**
         * 01: Create User in Keycloak
         */

        /**
         * 02: Create User in Mongodb
         */

        //Transform
        transform(userApi);
        userRepository.save(user);

        return true;
    }

    private void transform(UserApiDTO userApiDTO) {

        user.setUserId(UUID.randomUUID());
        user.setFirstName(userApiDTO.getFirstName());
        user.setLastName(userApiDTO.getLastName());
        user.setEmail(userApiDTO.getEmail());
        user.setU1(userApiDTO.getU1());
        user.setActive(false);

    }


}
