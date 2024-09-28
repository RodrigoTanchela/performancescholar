package com.performancescholar.model;

import java.time.LocalDate;

import com.performancescholar.model.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends Usuario {

	public Administrador(Long id, String nome, String email, String senha, Role tipo, LocalDate dataCriacao,
			Boolean ativo) {
		super(id, nome, email, senha, tipo, dataCriacao, ativo);
	}

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

}
