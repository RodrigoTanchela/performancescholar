package com.performancescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.performancescholar.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
