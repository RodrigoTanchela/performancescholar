package com.performancescholar.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private LocalDateTime dataRegistro;

    public Nota(Long id, Double valor, LocalDateTime dataRegistro, Aluno aluno, Atividade atividade) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataRegistro = dataRegistro;
		this.aluno = aluno;
		this.atividade = atividade;
	}

	public Nota() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Atividade atividade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, atividade, dataRegistro, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(atividade, other.atividade)
				&& Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id)
				&& Objects.equals(valor, other.valor);
	}
}
