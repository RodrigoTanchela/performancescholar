package com.performancescholar.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String periodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    
    @ManyToOne
    private Professor professor;
    
    @ManyToMany
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "turma")
    private List<Atividade> atividades;

	public Turma(Long id, String nome, String periodo, LocalDate dataInicio, LocalDate dataFim, Professor professor,
			List<Aluno> alunos, List<Atividade> atividades) {
		super();
		this.id = id;
		this.nome = nome;
		this.periodo = periodo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.professor = professor;
		this.alunos = alunos;
		this.atividades = atividades;
	}

	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alunos, atividades, dataFim, dataInicio, id, nome, periodo, professor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(alunos, other.alunos) && Objects.equals(atividades, other.atividades)
				&& Objects.equals(dataFim, other.dataFim) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(periodo, other.periodo) && Objects.equals(professor, other.professor);
	}
}
