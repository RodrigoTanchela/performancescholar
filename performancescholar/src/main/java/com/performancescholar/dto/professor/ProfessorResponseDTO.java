package com.performancescholar.dto.professor;

import java.time.LocalDateTime;

import com.performancescholar.model.enums.Role;

public record ProfessorResponseDTO(String nome, String email, Role papel, LocalDateTime dataDeCriacao,
		Boolean ativo, String especialidade) {
}
