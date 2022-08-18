package br.com.bb.trivia.service;


import br.com.bb.trivia.model.Partida;
import br.com.bb.trivia.model.Pergunta;
import br.com.bb.trivia.model.Resposta;

import java.util.List;

public interface PartidaService {
    Partida iniciar(Long idJogador);

    Pergunta buscarProximaPergunta(Long idPartida);

    Partida pularPergunta(Long idPartida);

    Partida responderPergunta(Long idPartida, Long idAlternativa);

    Partida desistir(Long idPartida);

    List<Partida> listar(Long idJogador);

    Partida buscar(Long idPartida);

}

