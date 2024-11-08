package io.github.ropereralk.vendeur.user.repository;

import io.github.ropereralk.vendeur.dto.mongo.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, UUID> {

}
