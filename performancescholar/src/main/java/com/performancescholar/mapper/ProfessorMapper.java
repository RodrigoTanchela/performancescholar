package com.performancescholar.mapper;

import com.performancescholar.dto.professor.ProfessorRequestDTO;
import com.performancescholar.dto.professor.ProfessorResponseDTO;
import com.performancescholar.model.Professor;

public class ProfessorMapper {
	
	public static ProfessorResponseDTO convertToDto(Professor professor) {
		ProfessorResponseDTO professorDto = new ProfessorResponseDTO(professor.getNome(), professor.getEmail(), professor.getPapel(), 
				professor.getDataDeCriacao(), professor.getAtivo(), professor.getEspecialidade());
		return professorDto;
	}
	
	public static Professor convertToModel(ProfessorRequestDTO professorDto) {
		 if (professorDto == null) {
	            return null;
	        }

	        Professor entity = new Professor();
	        entity.setId(professorDto.id());
	        entity.setNome(professorDto.nome());
	        entity.setEmail(professorDto.email());
	        entity.setSenha(professorDto.senha());
	        entity.setPapel(professorDto.papel());
	        entity.setDataDeCriacao(professorDto.dataDeCriacao());
	        entity.setAtivo(professorDto.ativo());
	        entity.setEspecialidade(professorDto.especialidade());
			
	        return entity;
	}
}