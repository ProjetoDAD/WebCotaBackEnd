package org.example.webcotaspringboot.controller;

import org.example.webcotaspringboot.model.User;
import org.example.webcotaspringboot.view.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
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
}
