package com.performancescholar.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.atividade.AtividadeDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.AtividadeMapper;
import com.performancescholar.model.Atividade;
import com.performancescholar.repository.AtividadeRepository;

@Service
public class AtividadeService {
	private Logger logger = Logger.getLogger(AtividadeService.class.getName());
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public List<AtividadeDTO> findAll() {
		logger.info("Finding all people");
		var atividades =  atividadeRepository.findAll().stream().map(AtividadeMapper::convertToDto).collect(Collectors.toList());
		return atividades;
	}

	public AtividadeDTO findById(Long id) {
		logger.info("Finding one atividade!");
		
		var entity = atividadeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = AtividadeMapper.convertToDto(entity);
		return vo;
	}
	
	public AtividadeDTO create(AtividadeDTO atividade) {
		//if(atividade == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one atividade!");
		var entity = AtividadeMapper.convertToModel(atividade);
		var vo = AtividadeMapper.convertToDto(atividadeRepository.save(entity));
		return vo;
	}

	
	public AtividadeDTO update(AtividadeDTO atividade) {
		//if(atividade == null) throw new RequiredObjectIsNullException();
		logger.info("Update one atividade!");
		Atividade entity = atividadeRepository.findById(atividade.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(atividade.id());
        entity.setTitulo(atividade.titulo());
        entity.setDescricao(atividade.descricao());
        entity.setTipoAtividade(atividade.tipoAtividade());
        entity.setDataEntrega(atividade.dataEntrega());
        entity.setTurma(atividade.turma());
        entity.setNotas(atividade.notas());
		
		var vo = AtividadeMapper.convertToDto(atividadeRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one atividade!");
	    var entity = atividadeRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    atividadeRepository.delete(entity);
	}
}
