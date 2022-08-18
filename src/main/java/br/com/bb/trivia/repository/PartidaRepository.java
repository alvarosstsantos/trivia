package br.com.bb.trivia.repository;

import br.com.bb.trivia.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    @Query("select p from Partida p where p.jogador_id = :jogador_id")
    List<Partida> findPartidaByJogadorId(@Param("jogador_id") Long idJogador);
}

