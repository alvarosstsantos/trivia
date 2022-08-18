package br.com.bb.trivia.controller;


import br.com.bb.trivia.dto.jogador.JogadorRankingDto;
import br.com.bb.trivia.dto.jogador.JogadorResponseDto;
import br.com.bb.trivia.model.Jogador;
import br.com.bb.trivia.service.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
    private final JogadorService jogadorService;
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @Operation(description = "Salvar um jogador")
    @PostMapping
    public ResponseEntity<JogadorResponseDto> salvar(@RequestBody @Valid Jogador jogador) {
        return ResponseEntity.ok(jogadorService.salvar(jogador));
    }

    @Operation(description = "Buscar ranking de jogadores")
    @GetMapping("/ranking")
    public ResponseEntity<List<JogadorRankingDto>> ranking() {
        return ResponseEntity.ok(jogadorService.ranking());
    }
}

