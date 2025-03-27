package org.example.webcotaspringboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "perfil")
public class User {

    @Id
    private String id;
    private String senha;
    private String email;
    private String nomeUsuario;
    private String metodo_investimento;
    private List<String> acoes_favoritas;
    private List<String> artigos_seguidos;
    private String celular;
    private List<String> estrategias_seguidas;
    private boolean verificacao_2fatores;

}
