package com.performancescholar.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.performancescholar.model.enums.TipoRelatorio;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "relatorio")
public class Relatorio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoRelatorio tipoRelatorio; 

    private LocalDateTime dataGeracao;

    private String arquivoExportado;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Relatorio() {
    }

    public Relatorio(TipoRelatorio tipoRelatorio, LocalDateTime dataGeracao, String arquivoExportado, Aluno aluno, Turma turma) {
        this.tipoRelatorio = tipoRelatorio;
        this.dataGeracao = dataGeracao;
        this.arquivoExportado = arquivoExportado;
        this.aluno = aluno;
        this.turma = turma;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoRelatorio getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(TipoRelatorio tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public LocalDateTime getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(LocalDateTime dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public String getArquivoExportado() {
		return arquivoExportado;
	}

	public void setArquivoExportado(String arquivoExportado) {
		this.arquivoExportado = arquivoExportado;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, arquivoExportado, dataGeracao, id, tipoRelatorio, turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relatorio other = (Relatorio) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(arquivoExportado, other.arquivoExportado)
				&& Objects.equals(dataGeracao, other.dataGeracao) && Objects.equals(id, other.id)
				&& tipoRelatorio == other.tipoRelatorio && Objects.equals(turma, other.turma);
	}
	
}
