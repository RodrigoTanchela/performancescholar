package com.performancescholar.dto.turma;

import java.time.LocalDate;
import java.util.List;

import com.performancescholar.model.Aluno;
import com.performancescholar.model.Atividade;
import com.performancescholar.model.Professor;

public record TurmaDTO(Long id, String nome, String periodo, LocalDate dataInicio, LocalDate dataFim, Professor professor,
		List<Aluno> alunos, List<Atividade> atividades) {

}
