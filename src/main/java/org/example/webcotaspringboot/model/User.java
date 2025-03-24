package org.example.webcotaspringboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
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
    private String nome_usuario;
    private String metodo_investimento;
    private List<FavoriteActions> acoes_favoritas;
    private List<ArtigosSeguidos> artigos_seguidos;
    private String celular;
    private List<StrategiesFollowed> estrategias_seguidas;

}
