package br.com.bb.trivia.repository;

import br.com.bb.trivia.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    @Query(value = "select * from Pergunta p left join Resposta r on r.pergunta_id = p.id where r.esta_ativa = true and r.partida_id = :partida_id limit 1")
    Pergunta findPerguntaByRespostaEhAtivaAndPartidaId(@Param("partida_id") Long idPartida);

    @Query(value = "select * from Pergunta p left outer join Resposta r on r.pergunta_id = pe.id and r.partida_id = :partida_id")
    Pergunta findPerguntaNotInRespostaByPartidaId(@Param("partida_id") Long idPartida);
}



