package com.performancescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.performancescholar.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

}
