package br.com.bb.trivia.dto.jogador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JogadorRankingDto {
    private Long id;
    private String usuario;
    private Integer pontuacao;
}
