package com.performancescholar.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.performancescholar.model.enums.TipoAtividade;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "atividade")
public class Atividade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;  // PROVA, TRABALHO, PROJETO

    private LocalDate dataEntrega;
    
    @ManyToOne
    private Turma turma;
    
    public Atividade(Long id, String titulo, String descricao, TipoAtividade tipoAtividade, LocalDate dataEntrega,
			Turma turma, List<Nota> notas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipoAtividade = tipoAtividade;
		this.dataEntrega = dataEntrega;
		this.turma = turma;
		this.notas = notas;
	}

	public Atividade() {
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "atividade")
    private List<Nota> notas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEntrega, descricao, id, notas, tipoAtividade, titulo, turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(dataEntrega, other.dataEntrega) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(notas, other.notas)
				&& tipoAtividade == other.tipoAtividade && Objects.equals(titulo, other.titulo)
				&& Objects.equals(turma, other.turma);
	}
    
}
