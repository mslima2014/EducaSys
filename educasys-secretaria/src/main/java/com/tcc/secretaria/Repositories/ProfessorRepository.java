package com.tcc.secretaria.Repositories;

import com.tcc.secretaria.database.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>{
}
