package com.performancescholar.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.relatorio.RelatorioDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.RelatorioMapper;
import com.performancescholar.model.Relatorio;
import com.performancescholar.repository.RelatorioRepository;

@Service
public class RelatorioService {
	private Logger logger = Logger.getLogger(RelatorioService.class.getName());
	
	@Autowired
	private RelatorioRepository relatorioRepository;
	
	public List<RelatorioDTO> findAll() {
		logger.info("Finding all people");
		var relatorios =  relatorioRepository.findAll().stream().map(RelatorioMapper::convertToDto).collect(Collectors.toList());
		return relatorios;
	}

	public RelatorioDTO findById(Long id) {
		logger.info("Finding one relatorio!");
		
		var entity = relatorioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = RelatorioMapper.convertToDto(entity);
		return vo;
	}
	
	public RelatorioDTO create(RelatorioDTO relatorio) {
		//if(relatorio == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one relatorio!");
		var entity = RelatorioMapper.convertToModel(relatorio);
		var vo = RelatorioMapper.convertToDto(relatorioRepository.save(entity));
		return vo;
	}

	
	public RelatorioDTO update(RelatorioDTO relatorio) {
		//if(relatorio == null) throw new RequiredObjectIsNullException();
		logger.info("Update one relatorio!");
		Relatorio entity = relatorioRepository.findById(relatorio.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(relatorio.id());
        entity.setTipoRelatorio(relatorio.tipoRelatorio());
        entity.setDataGeracao(relatorio.dataGeracao());
        entity.setArquivoExportado(relatorio.arquivoExportado());
        entity.setAluno(relatorio.aluno());
        entity.setTurma(relatorio.turma());
		
		var vo = RelatorioMapper.convertToDto(relatorioRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one relatorio!");
	    var entity = relatorioRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    relatorioRepository.delete(entity);
	}
}
