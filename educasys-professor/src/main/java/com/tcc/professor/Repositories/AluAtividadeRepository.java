package com.tcc.professor.Repositories;

import com.tcc.professor.database.AluAtividade;
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
    @Query("DELETE FROM AluAtividade a WHERE a.atividadefk.id = :id")
    void deleteAtividadeByIdAtividade(@Param("id") Long id);

    @Query("SELECT a FROM AluAtividade a WHERE a.entrega = true AND a.disciplinafk.codigo = :idd AND a.atividadefk.id = :ida")
    List<AluAtividade> getAtividadesEntregues(@Param("idd") Long idd, @Param("ida") Long ida);
}
