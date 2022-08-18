package br.com.bb.trivia.controller;


import br.com.bb.trivia.model.Pergunta;
import br.com.bb.trivia.service.PerguntaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    private final PerguntaService perguntaService;
    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @Operation(description = "Salvar uma pergunta")
    @PostMapping
    public ResponseEntity<Pergunta> salvar(@RequestBody @Valid Pergunta pergunta) {
        return ResponseEntity.ok(perguntaService.salvar(pergunta));
    }

}

