package com.performancescholar.dto.aluno;

import java.time.LocalDate;
import com.performancescholar.model.enums.Role;

public record AlunoUpdateDTO(Long id, String nome, String email, String senha, Role tipo, LocalDate dataCriacao,
		Boolean ativo, String matricula) {

}
