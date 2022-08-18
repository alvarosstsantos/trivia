package br.com.bb.trivia.repository;

import br.com.bb.trivia.dto.jogador.JogadorRankingDto;
import br.com.bb.trivia.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    @Query(value = "select j.id, j.usuario, sum(p.pontuacao) as pontuacao from Jogador j left join Partida p on p.jogador_id = j.id order by pontuacao")
    List<JogadorRankingDto> getJogadorOrderedByPartidaPontuacaoSum();
}



