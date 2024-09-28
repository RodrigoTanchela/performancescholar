package com.performancescholar.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.performancescholar.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario {
	
	@Column(name = "matricula", unique = true, nullable = false, length = 30)
	private String matricula;
	
	public Aluno() {
	}

	public Aluno(Long id, String nome, String email, String senha, Role papel, LocalDate dataCriacao,
			Boolean ativo, String matricula) {
		super(id, nome, email, senha, papel, dataCriacao, ativo);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String generateMatricula() {
		return UUID.randomUUID().toString().substring(0, 11);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(matricula);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}

}
