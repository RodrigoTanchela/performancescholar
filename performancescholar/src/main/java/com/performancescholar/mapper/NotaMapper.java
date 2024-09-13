package com.performancescholar.mapper;


import com.performancescholar.dto.nota.NotaDTO;
import com.performancescholar.model.Nota;

public class NotaMapper {
	
	public static NotaDTO convertToDto(Nota nota) {
		NotaDTO notaDto = new NotaDTO(nota.getId(), nota.getValor(), nota.getDataRegistro(), nota.getAluno(), 
				nota.getAtividade());
		return notaDto;
	}
	
	public static Nota convertToModel(NotaDTO notaDto) {
		 if (notaDto == null) {
	            return null;
	        }

	        Nota entity = new Nota();
	        entity.setId(notaDto.id());
	        entity.setValor(notaDto.valor());
	        entity.setDataRegistro(notaDto.dataRegistro());
	        entity.setAluno(notaDto.aluno());
	        entity.setAtividade(notaDto.atividade());
			
	        return entity;
	}
}