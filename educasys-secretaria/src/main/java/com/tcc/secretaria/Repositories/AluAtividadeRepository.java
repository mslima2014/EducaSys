package com.tcc.secretaria.Repositories;

import com.tcc.secretaria.database.AluAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AluAtividadeRepository extends JpaRepository<AluAtividade, Long>{
    @Transactional
    @Modifying
    @Query("DELETE FROM AluAtividade a WHERE a.alunofk.id = :id AND a.disciplinafk.codigo = :idd")
    void deleteAtividadeByIdAlunoAndIdDisciplina(@Param("id") Long id, @Param("idd")Long idd);

    @Transactional
    @Modifying
    @Query("DELETE FROM AluAtividade  a WHERE a.disciplinafk.codigo =:codigo")
    void deleteAtividadeByIdDisciplina(@Param("codigo") Long codigo);

}
