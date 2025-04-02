package org.example.webcotaspringboot.view.service;

import org.example.webcotaspringboot.model.Login;
import org.example.webcotaspringboot.model.User;
import org.example.webcotaspringboot.view.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> saveUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getLogin(Login login) {
        return userRepository.findByEmail(login.getEmail());
    }

}
