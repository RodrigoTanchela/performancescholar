package com.performancescholar.dto.aluno;

import java.time.LocalDate;

import com.performancescholar.model.enums.Role;

public record AlunoResponseDTO(String nome, String email, Role tipo, LocalDate dataCriacao,
		Boolean ativo, String matricula) {
}
