package br.com.bb.trivia.controller;


import br.com.bb.trivia.dto.partida.IniciarPartidaDto;
import br.com.bb.trivia.model.Partida;
import br.com.bb.trivia.model.Pergunta;
import br.com.bb.trivia.model.Resposta;
import br.com.bb.trivia.service.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partida")
public class PartidaController {
    private final PartidaService partidaService;
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @Operation(description = "Iniciar uma partida")
    @PostMapping("/iniciar")
    public ResponseEntity<Partida> iniciar(@RequestBody IniciarPartidaDto iniciarPartidaDto) {
        return ResponseEntity.ok(partidaService.iniciar(iniciarPartidaDto.getIdJogador()));
    }

    @Operation(description = "Buscar próxima pergunta de uma partida")
    @GetMapping("/{idPartida}/proxima-pergunta")
    public ResponseEntity<Pergunta> buscarProximaPergunta(@PathVariable Long idPartida) {
        return ResponseEntity.ok(partidaService.buscarProximaPergunta(idPartida));
    }

    @Operation(description = "Pular pergunta atual de uma partida")
    @PutMapping("/{idPartida}/pular-pergunta")
    public ResponseEntity<Partida> pularPergunta(@PathVariable Long idPartida) {
        return ResponseEntity.ok(partidaService.pularPergunta(idPartida));
    }

    @Operation(description = "Responder pergunta atual de uma partida")
    @PutMapping("/{idPartida}/responder-pergunta/{idAlternativa}")
    public ResponseEntity<Partida> responderPergunta(@PathVariable Long idPartida, @PathVariable Long idAlternativa) {
        return ResponseEntity.ok(partidaService.responderPergunta(idPartida, idAlternativa));
    }

    @Operation(description = "Desistir de uma partida")
    @PutMapping("/{idPartida}/desistir")
    public ResponseEntity<Partida> desistir(@PathVariable Long idPartida) {
        return ResponseEntity.ok(partidaService.desistir(idPartida));
    }

    @Operation(description = "Listar partidas de um jogador")
    @GetMapping("/listar-partidas/{idJogador}")
    public ResponseEntity<List<Partida>> listar(@PathVariable Long idJogador) {
        return ResponseEntity.ok(partidaService.listar(idJogador));
    }

    @Operation(description = "Buscar uma partida de um jogador")
    @GetMapping("/{idPartida}")
    public ResponseEntity<Partida> buscar(@PathVariable Long idPartida) {
        return ResponseEntity.ok(partidaService.buscar(idPartida));
    }


}

