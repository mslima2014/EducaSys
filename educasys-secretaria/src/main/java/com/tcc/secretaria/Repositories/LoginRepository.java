package com.tcc.secretaria.Repositories;

import com.tcc.secretaria.database.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

    @Transactional
    @Modifying
    @Query("DELETE FROM Login l WHERE l.code =:code")
    void deleteLoginByCode(@Param("code") String code);
}
