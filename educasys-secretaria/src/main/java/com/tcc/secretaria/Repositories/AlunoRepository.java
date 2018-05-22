package com.tcc.secretaria.Repositories;

import com.tcc.secretaria.database.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno,Long> {
    @Query("SELECT a FROM Aluno a WHERE UPPER(a.nome) LIKE CONCAT('%',UPPER(:nome),'%')")
    List<Aluno> searchAluno(@Param("nome") String nome);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Aluno a SET a.telefone = :telefone, a.senha=:senha, a.rg= :rg, a.nome= :nome, a.endereco= :endereco, a.email= :email, a.dataN= :dataN, a.cpf= :cpf, a.nomeM = :nomeM, a.nomeP = :nomeP WHERE a.id = :id")
    void updateAluno(@Param("telefone")String telefone, @Param("senha") String senha, @Param("rg") String rg, @Param("nome")String nome, @Param("endereco") String endereco, @Param("email") String email, @Param("dataN") Date dataN, @Param("cpf")String cpf,@Param("nomeM")String nomeM, @Param("nomeP")String nomeP, @Param("id") Long id);

}
