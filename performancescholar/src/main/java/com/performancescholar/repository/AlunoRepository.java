package com.performancescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.performancescholar.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
