package com.performancescholar.mapper;

import com.performancescholar.dto.aluno.AlunoRequestDTO;
import com.performancescholar.dto.aluno.AlunoResponseDTO;
import com.performancescholar.model.Aluno;

public class AlunoMapper {
	
	public static AlunoResponseDTO convertToDto(Aluno aluno) {
		AlunoResponseDTO alunoDto = new AlunoResponseDTO(aluno.getNome(), aluno.getEmail(), aluno.getPapel(), 
				aluno.getDataDeCriacao(), aluno.getAtivo(), aluno.getMatricula());
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
	        entity.setPapel(alunoDto.papel());
	        entity.setDataDeCriacao(alunoDto.dataDeCriacao());
	        entity.setAtivo(alunoDto.ativo());
	        entity.setMatricula(alunoDto.matricula());
			
	        return entity;
	}
}