package com.performancescholar.dto.administrador;

import java.time.LocalDate;

import com.performancescholar.model.enums.Role;

public record AdministradorResponseDTO(String nome, String email, Role tipo, LocalDate dataCriacao,
		Boolean ativo) {
}
