package br.com.bb.trivia.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @ColumnDefault("true")
    private Boolean estaAtiva;

    @NotNull
    @NotBlank
    @ColumnDefault("0")
    private Integer pontuacao;

    @ManyToOne()
    @JoinColumn(name="jogador_id", referencedColumnName = "id")
    private Jogador jogador;

    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL)
    private Set<Resposta> resposta;
}
