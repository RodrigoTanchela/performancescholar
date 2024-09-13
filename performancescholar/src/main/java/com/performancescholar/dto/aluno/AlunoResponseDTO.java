package com.performancescholar.dto.aluno;

import java.time.LocalDateTime;

import com.performancescholar.model.enums.Role;

public record AlunoResponseDTO(String nome, String email, Role papel, LocalDateTime dataDeCriacao,
		Boolean ativo, String matricula) {
}
