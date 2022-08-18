package br.com.bb.trivia.dto.jogador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JogadorResponseDto {
    private Long id;
    private String nome;
    private String usuario;
}
