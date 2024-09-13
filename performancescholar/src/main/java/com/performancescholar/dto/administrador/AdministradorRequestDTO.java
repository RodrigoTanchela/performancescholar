package com.performancescholar.dto.administrador;

import java.time.LocalDateTime;

import com.performancescholar.model.enums.Role;

public record AdministradorRequestDTO(Long id, String nome, String email, String senha, Role papel, LocalDateTime dataDeCriacao,
		Boolean ativo, String especialidade) {
}
