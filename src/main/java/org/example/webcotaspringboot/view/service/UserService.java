package org.example.webcotaspringboot.view.service;

import org.example.webcotaspringboot.model.Login;
import org.example.webcotaspringboot.model.User;
import org.example.webcotaspringboot.view.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public ResponseEntity<Object> updateUserPartial(User updatedUser, String id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        User existingUser = userOptional.get();

        if (updatedUser.getSenha() != null) {
            existingUser.setSenha(updatedUser.getSenha());
        }
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getNomeUsuario() != null) {
            existingUser.setNomeUsuario(updatedUser.getNomeUsuario());
        }
        if (updatedUser.getMetodo_investimento() != null) {
            existingUser.setMetodo_investimento(updatedUser.getMetodo_investimento());
        }
        if (updatedUser.getCelular() != null) {
            existingUser.setCelular(updatedUser.getCelular());
        }
        if (updatedUser.getAcoes_favoritas() != null) {
            existingUser.setAcoes_favoritas(updatedUser.getAcoes_favoritas());
        }
        if (updatedUser.getArtigos_seguidos() != null) {
            existingUser.setArtigos_seguidos(updatedUser.getArtigos_seguidos());
        }
        if (updatedUser.getEstrategias_seguidas() != null) {
            existingUser.setEstrategias_seguidas(updatedUser.getEstrategias_seguidas());
        }

        userRepository.save(existingUser);

        return ResponseEntity.ok("Usuário atualizado parcialmente com sucesso.");
    }

     public List<Optional<User>> getUserById(String id){
         return Collections.singletonList(userRepository.findById(id));
     }

}
