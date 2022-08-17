package br.com.bb.trivia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "nome nao pode ser null")
    @NotEmpty(message = "nome nao pode ser vazio")
    private String nome;

    @NotNull(message = "usuario nao pode ser null")
    @NotEmpty(message = "usuario nao pode ser vazio")
    private String usuario;

    @JsonIgnoreProperties(allowGetters = true)
    private String senha;

    @OneToMany(mappedBy = "jogador")
    private Set<Partida> partida;

}
