package com.performancescholar.dto.administrador;

import java.time.LocalDate;

import com.performancescholar.model.enums.Role;

public record AdministradorRequestDTO(Long id, String nome, String email, String senha, Role tipo, LocalDate dataCriacao,
		Boolean ativo) {
}
