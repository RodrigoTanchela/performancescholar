package com.performancescholar.mapper;


import com.performancescholar.dto.turma.TurmaDTO;
import com.performancescholar.model.Turma;

public class TurmaMapper {
	
	public static TurmaDTO convertToDto(Turma turma) {
		TurmaDTO turmaDto = new TurmaDTO(turma.getId(), turma.getNome(), turma.getPeriodo(), turma.getDataInicio(), 
				turma.getDataFim(), turma.getProfessor(), turma.getAlunos(), turma.getAtividades());
		return turmaDto;
	}
	
	public static Turma convertToModel(TurmaDTO turmaDto) {
		 if (turmaDto == null) {
	            return null;
	        }

	        Turma entity = new Turma();
	        entity.setId(turmaDto.id());
	        entity.setNome(turmaDto.nome());
	        entity.setPeriodo(turmaDto.periodo());
	        entity.setDataInicio(turmaDto.dataInicio());
	        entity.setDataFim(turmaDto.dataFim());
	        entity.setProfessor(turmaDto.professor());
	        entity.setAlunos(turmaDto.alunos());
	        entity.setAtividades(turmaDto.atividades());
			
	        return entity;
	}
}