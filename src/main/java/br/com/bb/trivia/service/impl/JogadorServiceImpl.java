package br.com.bb.trivia.service.impl;

import br.com.bb.trivia.dto.jogador.JogadorRankingDto;
import br.com.bb.trivia.dto.jogador.JogadorResponseDto;
import br.com.bb.trivia.model.Jogador;
import br.com.bb.trivia.repository.JogadorRepository;
import br.com.bb.trivia.service.JogadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorServiceImpl implements JogadorService {
    private final JogadorRepository jogadorRepository;

    public JogadorServiceImpl(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public JogadorResponseDto salvar(Jogador jogador) {
        jogador = jogadorRepository.save(jogador);

        return new JogadorResponseDto(jogador.getId(), jogador.getNome(), jogador.getUsuario());
    }

    @Override
    public List<JogadorRankingDto> ranking() {
        return jogadorRepository.getJogadorOrderedByPartidaPontuacaoSum();
    }
}

