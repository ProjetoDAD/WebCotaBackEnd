package org.example.webcotaspringboot.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    public ResponseEntity<Object> login(@RequestBody Login login) {
        return service.login(login);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deletar(@RequestHeader String id) {
        ResponseEntity<Object> response = service.deleteUser(id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Erro ao deletar usuário: " + response.getBody());
        }

    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> updateUser(@RequestHeader String id,
                                             @RequestBody User user,
                                             HttpServletResponse response) {
        ResponseEntity<Object> objectResponseEntity = service.updateUserPartial(user, id);

        if (objectResponseEntity.getStatusCode().is2xxSuccessful()) {
            Cookie cookie = new Cookie("userAtualizado", "true");
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60);

            response.addCookie(cookie);

            return ResponseEntity.ok(objectResponseEntity.getBody());
        } else {
            return ResponseEntity.status(objectResponseEntity.getStatusCode())
                    .body("Erro ao atualizar usuário: " + objectResponseEntity.getBody());
        }
    }

    @GetMapping
    public ResponseEntity<List<Optional<User>>> getUserById(@RequestHeader String id) {
        List<Optional<User>> userById = service.getUserById(id);
        if (userById.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userById);
    }

}
