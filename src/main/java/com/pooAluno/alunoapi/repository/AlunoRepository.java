package com.pooAluno.alunoapi.repository;

import com.pooAluno.alunoapi.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
}
