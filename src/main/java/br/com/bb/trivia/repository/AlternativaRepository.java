package br.com.bb.trivia.repository;

import br.com.bb.trivia.model.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
}



