package com.performancescholar.dto.nota;

import java.time.LocalDateTime;

import com.performancescholar.model.Aluno;
import com.performancescholar.model.Atividade;

public record NotaDTO(Long id, Double valor, LocalDateTime dataRegistro, Aluno aluno, Atividade atividade) {

}
