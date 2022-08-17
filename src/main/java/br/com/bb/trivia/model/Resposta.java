package br.com.bb.trivia.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "resposta nao pode ser null")
    @NotEmpty(message = "resposta nao pode ser vazio")
    @ColumnDefault("true")
    private Boolean estaAtiva;

    @NotNull
    @OneToOne
    @JoinColumn(name="pergunta_id", referencedColumnName = "id")
    private Pergunta pergunta;

    @NotNull
    @OneToOne
    @JoinColumn(name="partida_id", referencedColumnName = "id")
    private Partida partida;

    @OneToOne
    @JoinColumn(name="alternativa_id", referencedColumnName = "id")
    private Alternativa alternativa;
}
