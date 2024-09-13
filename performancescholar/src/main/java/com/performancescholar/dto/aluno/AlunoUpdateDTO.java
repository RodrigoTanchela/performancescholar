package com.performancescholar.dto.aluno;

import java.time.LocalDateTime;

import com.performancescholar.model.enums.Role;

public record AlunoUpdateDTO(Long id, String nome, String email, String senha, Role papel, LocalDateTime dataDeCriacao,
		Boolean ativo, String matricula) {

}
