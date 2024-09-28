package com.performancescholar.mapper;

import com.performancescholar.dto.aluno.AlunoRequestDTO;
import com.performancescholar.dto.aluno.AlunoResponseDTO;
import com.performancescholar.model.Aluno;

public class AlunoMapper {
	
	public static AlunoResponseDTO convertToDto(Aluno aluno) {
		AlunoResponseDTO alunoDto = new AlunoResponseDTO(aluno.getNome(), aluno.getEmail(), aluno.getTipo(), 
				aluno.getDataCriacao(), aluno.getAtivo(), aluno.getMatricula());
		return alunoDto;
	}
	
	public static Aluno convertToModel(AlunoRequestDTO alunoDto) {
		 if (alunoDto == null) {
	            return null;
	        }

	        Aluno entity = new Aluno();
	        entity.setId(alunoDto.id());
	        entity.setNome(alunoDto.nome());
	        entity.setEmail(alunoDto.email());
	        entity.setSenha(alunoDto.senha());
	        entity.setTipo(alunoDto.tipo());
	        entity.setDataCriacao(alunoDto.dataCriacao());
	        entity.setAtivo(alunoDto.ativo());
	        entity.setMatricula(alunoDto.matricula());
			
	        return entity;
	}
}