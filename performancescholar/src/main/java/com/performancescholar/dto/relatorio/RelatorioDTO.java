package com.performancescholar.dto.relatorio;

import java.time.LocalDateTime;

import com.performancescholar.model.Aluno;
import com.performancescholar.model.Turma;
import com.performancescholar.model.enums.TipoRelatorio;

public record RelatorioDTO(Long id, TipoRelatorio tipoRelatorio, LocalDateTime dataGeracao, String arquivoExportado, Aluno aluno, Turma turma) {

}
