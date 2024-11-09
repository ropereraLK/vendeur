package io.github.ropereralk.vendeur.user.service;

import io.github.ropereralk.vendeur.dto.api.UserApiDTO;
import io.github.ropereralk.vendeur.dto.mongo.UserDTO;
import io.github.ropereralk.vendeur.user.repository.UserRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    UserDTO user = new UserDTO();

    @Autowired
    private Validator validator;

    @Autowired
    UserRepository userRepository;

    public boolean createUser(final UserApiDTO userApi) throws Exception {

        /**
         * 01: Create User in Keycloak
         * KeyClock User Creation            T     F
         * OutPutMessage Received(Async)     T/F   F
         * Vendur DB                         T/F   T/F
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

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<UserDTO> violation : violations) {
                System.out.println("Validation failed: " + violation.getMessage());
            }
            throw new RuntimeException("Validation Failed");
        }

    }


}
