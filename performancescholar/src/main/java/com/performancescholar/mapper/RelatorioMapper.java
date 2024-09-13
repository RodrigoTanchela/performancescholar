package com.performancescholar.mapper;


import com.performancescholar.dto.relatorio.RelatorioDTO;
import com.performancescholar.model.Relatorio;

public class RelatorioMapper {
	
	public static RelatorioDTO convertToDto(Relatorio relatorio) {
		RelatorioDTO RelatorioDto = new RelatorioDTO(relatorio.getId(), relatorio.getTipoRelatorio(), relatorio.getDataGeracao(), relatorio.getArquivoExportado(), 
				relatorio.getAluno(), relatorio.getTurma());
		return RelatorioDto;
	}
	
	public static Relatorio convertToModel(RelatorioDTO relatorioDto) {
		 if (relatorioDto == null) {
	            return null;
	        }

	        Relatorio entity = new Relatorio();
	        entity.setId(relatorioDto.id());
	        entity.setTipoRelatorio(relatorioDto.tipoRelatorio());
	        entity.setDataGeracao(relatorioDto.dataGeracao());
	        entity.setArquivoExportado(relatorioDto.arquivoExportado());
	        entity.setAluno(relatorioDto.aluno());
	        entity.setTurma(relatorioDto.turma());

			
	        return entity;
	}
}