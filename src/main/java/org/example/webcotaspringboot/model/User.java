package org.example.webcotaspringboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", metodo_investimento='" + metodo_investimento + '\'' +
                ", acoes_favoritas=" + acoes_favoritas +
                ", artigos_seguidos=" + artigos_seguidos +
                ", celular='" + celular + '\'' +
                ", estrategias_seguidas=" + estrategias_seguidas +
                ", verificacao_2fatores=" + verificacao_2fatores +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getMetodo_investimento() {
        return metodo_investimento;
    }

    public List<String> getAcoes_favoritas() {
        return acoes_favoritas;
    }

    public List<String> getArtigos_seguidos() {
        return artigos_seguidos;
    }

    public String getCelular() {
        return celular;
    }

    public List<String> getEstrategias_seguidas() {
        return estrategias_seguidas;
    }

    public boolean isVerificacao_2fatores() {
        return verificacao_2fatores;
    }
}
