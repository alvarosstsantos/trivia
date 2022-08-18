package br.com.bb.trivia.repository;

import br.com.bb.trivia.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    @Query(value = "select * Resposta r on r.pergunta_id = p.id where r.esta_ativa = true and r.partida_id = :partida_id limit 1")
    Resposta findRespostaEhAtivaByPartidaId(@Param("partida_id") Long idPartida);
}



