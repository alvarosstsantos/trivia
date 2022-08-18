package br.com.bb.trivia.repository;

import br.com.bb.trivia.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    @Query(value = "select * from Pergunta p left outer join Resposta r on r.pergunta_id = pe.id and r.partida_id = :partida_id")
    List<Pergunta> findPerguntaNotInRespostaByPartidaId(@Param("partida_id") Long idPartida);
}



