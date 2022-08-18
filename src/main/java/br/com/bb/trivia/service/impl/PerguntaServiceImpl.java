package br.com.bb.trivia.service.impl;


import br.com.bb.trivia.model.Pergunta;
import br.com.bb.trivia.repository.PerguntaRepository;
import br.com.bb.trivia.service.PerguntaService;
import org.springframework.stereotype.Service;

@Service
public class PerguntaServiceImpl implements PerguntaService {
    private final PerguntaRepository perguntaRepository;

    public PerguntaServiceImpl(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    @Override
    public Pergunta salvar(Pergunta pergunta) {
        return perguntaRepository.save(pergunta);
    }
}

