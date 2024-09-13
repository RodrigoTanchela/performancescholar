package com.performancescholar.mapper;


import com.performancescholar.dto.atividade.AtividadeDTO;
import com.performancescholar.model.Atividade;

public class AtividadeMapper {
	
	public static AtividadeDTO convertToDto(Atividade atividade) {
		AtividadeDTO atividadeDto = new AtividadeDTO(atividade.getId(), atividade.getTitulo(), atividade.getDescricao(), atividade.getTipoAtividade(), 
				atividade.getDataEntrega(), atividade.getTurma(), atividade.getNotas());
		return atividadeDto;
	}
	
	public static Atividade convertToModel(AtividadeDTO atividadeDto) {
		 if (atividadeDto == null) {
	            return null;
	        }

	        Atividade entity = new Atividade();
	        entity.setId(atividadeDto.id());
	        entity.setTitulo(atividadeDto.titulo());
	        entity.setDescricao(atividadeDto.descricao());
	        entity.setTipoAtividade(atividadeDto.tipoAtividade());
	        entity.setDataEntrega(atividadeDto.dataEntrega());
	        entity.setTurma(atividadeDto.turma());
	        entity.setNotas(atividadeDto.notas());
			
	        return entity;
	}
}