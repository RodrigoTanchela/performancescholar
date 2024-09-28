package com.performancescholar.dto.professor;

import java.time.LocalDate;

import com.performancescholar.model.enums.Role;

public record ProfessorRequestDTO(Long id, String nome, String email, String senha, Role tipo, LocalDate dataCriacao,
		Boolean ativo, String especialidade) {
}
