package br.com.bb.trivia.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "texto nao pode ser null")
    @NotEmpty(message = "texto nao pode ser vazio")
    private String texto;

    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
    private Set<Alternativa> alternativa;
}
