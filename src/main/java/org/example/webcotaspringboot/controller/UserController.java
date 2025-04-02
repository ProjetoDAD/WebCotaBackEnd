package org.example.webcotaspringboot.controller;

import org.example.webcotaspringboot.model.Login;
import org.example.webcotaspringboot.model.User;
import org.example.webcotaspringboot.view.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/addUser")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping(value = "/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        Optional<User> user = service.getLogin(login);

        if (user.isPresent() && user.get().getSenha().equals(login.getSenha())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("E-mail ou senha inválidos.");
        }
    }

}
