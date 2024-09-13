package com.performancescholar.dto.professor;

import java.time.LocalDateTime;

import com.performancescholar.model.enums.Role;

public record ProfessorRequestDTO(Long id, String nome, String email, String senha, Role papel, LocalDateTime dataDeCriacao,
		Boolean ativo, String especialidade) {
}
