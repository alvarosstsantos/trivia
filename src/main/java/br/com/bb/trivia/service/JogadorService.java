package br.com.bb.trivia.service;


import br.com.bb.trivia.dto.jogador.JogadorRankingDto;
import br.com.bb.trivia.dto.jogador.JogadorResponseDto;
import br.com.bb.trivia.model.Jogador;

import java.util.List;

public interface JogadorService {
    JogadorResponseDto salvar(Jogador jogador);

    List<JogadorRankingDto> ranking();
}