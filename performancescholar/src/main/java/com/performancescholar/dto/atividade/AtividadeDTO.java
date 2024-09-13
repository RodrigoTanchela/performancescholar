package com.performancescholar.dto.atividade;

import java.time.LocalDate;
import java.util.List;

import com.performancescholar.model.Nota;
import com.performancescholar.model.Turma;
import com.performancescholar.model.enums.TipoAtividade;

public record AtividadeDTO(Long id, String titulo, String descricao, TipoAtividade tipoAtividade, LocalDate dataEntrega,
		Turma turma, List<Nota> notas) {

}
