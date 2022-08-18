package br.com.bb.trivia.service.impl;

import br.com.bb.trivia.dto.jogador.JogadorRankingDto;
import br.com.bb.trivia.dto.jogador.JogadorResponseDto;
import br.com.bb.trivia.model.Jogador;
import br.com.bb.trivia.model.Partida;
import br.com.bb.trivia.model.Pergunta;
import br.com.bb.trivia.model.Resposta;
import br.com.bb.trivia.repository.*;
import br.com.bb.trivia.service.JogadorService;
import br.com.bb.trivia.service.PartidaService;
import br.com.bb.trivia.service.PerguntaService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class PartidaServiceImpl implements PartidaService {
    private final PartidaRepository partidaRepository;
    private final JogadorRepository jogadorRepository;
    private final RespostaRepository respostaRepository;
    private final AlternativaRepository alternativaRepository;
    private final PerguntaRepository perguntaRepository;


    public PartidaServiceImpl(PartidaRepository partidaRepository, JogadorRepository jogadorRepository, RespostaRepository respostaRepository, AlternativaRepository alternativaRepository, PerguntaRepository perguntaRepository) {
        this.partidaRepository = partidaRepository;
        this.jogadorRepository = jogadorRepository;
        this.respostaRepository = respostaRepository;
        this.alternativaRepository = alternativaRepository;
        this.perguntaRepository = perguntaRepository;
    }


    @Override
    public Partida iniciar(Long idJogador) {
        Partida partida = new Partida();
        partida.setJogador(jogadorRepository.getReferenceById(idJogador));

        return partidaRepository.save(partida);
    }

    @Override
    public Pergunta buscarProximaPergunta(Long idPartida) {
        Resposta resposta = respostaRepository.findRespostaEhAtivaByPartidaId(idPartida);

        if(!Objects.isNull(resposta)) {
            return resposta.getPergunta();
        }

        List<Pergunta> perguntasDisponiveis = perguntaRepository.findPerguntaNotInRespostaByPartidaId(idPartida);
        Collections.shuffle(perguntasDisponiveis);

        Pergunta pergunta = perguntasDisponiveis.get(0);

        resposta = new Resposta();
        resposta.setPartida(partidaRepository.getReferenceById(idPartida));
        resposta.setPergunta(pergunta);

        return pergunta;
    }

    @Override
    public Partida pularPergunta(Long idPartida) {
        Resposta resposta = respostaRepository.findRespostaEhAtivaByPartidaId(idPartida);
        resposta.setEstaAtiva(false);

        return partidaRepository.getReferenceById(idPartida);
    }

    @Override
    public Partida responderPergunta(Long idPartida, Long idAlternativa) {
        Resposta resposta = respostaRepository.findRespostaEhAtivaByPartidaId(idPartida);
        resposta.setAlternativa(alternativaRepository.getReferenceById(idAlternativa));
        resposta.setEstaAtiva(false);

        respostaRepository.save(resposta);

        return partidaRepository.getReferenceById(idPartida);
    }

    @Override
    public Partida desistir(Long idPartida) {
        Resposta resposta = respostaRepository.findRespostaEhAtivaByPartidaId(idPartida);
        resposta.setEstaAtiva(false);

        respostaRepository.save(resposta);

        Partida partida = partidaRepository.getReferenceById(idPartida);
        partida.setEstaAtiva(false);

        partidaRepository.save(partida);

        return partida;
    }

    @Override
    public List<Partida> listar(Long idJogador) {
        return partidaRepository.findPartidaByJogadorId(idJogador);
    }

    @Cacheable("ranking")
    @Override
    public Partida buscar(Long idPartida) {
        return partidaRepository.getReferenceById(idPartida);
    }

}