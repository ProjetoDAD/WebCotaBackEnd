package org.example.webcotaspringboot.view;

import org.example.webcotaspringboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByNomeUsuario(String nomeUsuario);

}
