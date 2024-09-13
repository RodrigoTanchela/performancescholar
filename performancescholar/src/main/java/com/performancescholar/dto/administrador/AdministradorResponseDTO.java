package com.performancescholar.dto.administrador;

import java.time.LocalDateTime;

import com.performancescholar.model.enums.Role;

public record AdministradorResponseDTO(String nome, String email, Role papel, LocalDateTime dataDeCriacao,
		Boolean ativo) {
}
