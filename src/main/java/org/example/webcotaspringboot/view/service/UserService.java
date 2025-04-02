package org.example.webcotaspringboot.view.service;

import org.example.webcotaspringboot.model.Login;
import org.example.webcotaspringboot.model.User;
import org.example.webcotaspringboot.view.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> saveUser(User user) {
        Login login = new Login();
        Random random = new Random();
        int randomId = 1000 + random.nextInt(9000);

        login.setEmail(user.getEmail());
        user.setId(String.valueOf(randomId));

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>("E-mail já cadastrado!", HttpStatus.CONFLICT);
        }

        userRepository.save(user);
        return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public ResponseEntity<Object> login(Login login) {
        Optional<User> userOptional = userRepository.findByEmail(login.getEmail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        User user = userOptional.get();

        if (!user.getSenha().equals(login.getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Object> deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("Usuário deletado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuário não encontrado!", HttpStatus.NOT_FOUND);
        }
    }

}
