package org.example.webcotaspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private Boolean verificacao_2fatores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getMetodo_investimento() {
        return metodo_investimento;
    }

    public void setMetodo_investimento(String metodo_investimento) {
        this.metodo_investimento = metodo_investimento;
    }

    public List<String> getAcoes_favoritas() {
        return acoes_favoritas;
    }

    public void setAcoes_favoritas(List<String> acoes_favoritas) {
        this.acoes_favoritas = acoes_favoritas;
    }

    public List<String> getArtigos_seguidos() {
        return artigos_seguidos;
    }

    public void setArtigos_seguidos(List<String> artigos_seguidos) {
        this.artigos_seguidos = artigos_seguidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<String> getEstrategias_seguidas() {
        return estrategias_seguidas;
    }

    public void setEstrategias_seguidas(List<String> estrategias_seguidas) {
        this.estrategias_seguidas = estrategias_seguidas;
    }

    public boolean isVerificacao_2fatores() {
        return verificacao_2fatores;
    }

    public void setVerificacao_2fatores(boolean verificacao_2fatores) {
        this.verificacao_2fatores = verificacao_2fatores;
    }
}
