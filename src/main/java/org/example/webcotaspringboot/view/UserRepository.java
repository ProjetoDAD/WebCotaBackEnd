package org.example.webcotaspringboot.view;

import org.example.webcotaspringboot.model.Login;
import org.example.webcotaspringboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}
