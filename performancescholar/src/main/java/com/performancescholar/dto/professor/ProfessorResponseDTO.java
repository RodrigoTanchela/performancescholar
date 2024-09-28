package com.performancescholar.dto.professor;

import java.time.LocalDate;

import com.performancescholar.model.enums.Role;

public record ProfessorResponseDTO(String nome, String email, Role tipo, LocalDate dataCriacao,
		Boolean ativo, String especialidade) {
}
