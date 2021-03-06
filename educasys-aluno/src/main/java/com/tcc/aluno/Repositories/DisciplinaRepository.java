package com.tcc.aluno.Repositories;

import com.tcc.aluno.database.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/*======================================================================================================================
||Interface responsavel por implementar as Query's nativas para obtenção, atualização e remoção de dados. Referente   ||
||ao modulo de alunos. e a entidade Disciplina.                                                                       ||
======================================================================================================================*/
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {
    @Transactional
    @Modifying
    @Query("SELECT a FROM Disciplina a WHERE a.codigo IN :idAluDis")
    List<Disciplina> getDisciplinasByIdAluDis(@Param("idAluDis") List<Long> idAluDis);
}
