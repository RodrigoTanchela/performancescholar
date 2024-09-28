package com.performancescholar.model;

import java.time.LocalDate;
import java.util.Objects;

import com.performancescholar.model.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Usuario {
	
	private String especialidade;

	public Professor(Long id, String nome, String email, String senha, Role papel, LocalDate dataCriacao,
			Boolean ativo, String especialidade) {
		super(id, nome, email, senha, papel, dataCriacao, ativo);
		this.especialidade = especialidade;
	}

	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(especialidade);
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
		Professor other = (Professor) obj;
		return Objects.equals(especialidade, other.especialidade);
	}

}
