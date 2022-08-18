package br.com.bb.trivia.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "texto nao pode ser vazio")
    @NotNull(message = "texto nao pode ser null")
    private String texto;

    @NotBlank(message = "ehCorreta nao pode ser vazio")
    @NotNull(message = "ehCorreta nao pode ser null")
    private Boolean ehCorreta;

    @ManyToOne()
    @JoinColumn(name="pergunta_id", referencedColumnName = "id")
    private Pergunta pergunta;
}
