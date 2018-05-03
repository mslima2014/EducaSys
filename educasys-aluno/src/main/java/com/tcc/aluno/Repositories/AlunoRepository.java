package com.tcc.aluno.Repositories;

import com.tcc.aluno.database.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno,Long> {
    @Query("SELECT a FROM Aluno a WHERE a.cpf = :cpf")
    Aluno getAlunoByCode(@Param("cpf") String cpf);
}