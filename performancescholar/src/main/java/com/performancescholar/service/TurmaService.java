package com.performancescholar.service;

import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.turma.TurmaDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.TurmaMapper;
import com.performancescholar.model.Turma;
import com.performancescholar.repository.TurmaRepository;

@Service
public class TurmaService {
	private Logger logger = Logger.getLogger(TurmaService.class.getName());
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<TurmaDTO> findAll() {
		logger.info("Finding all people");
		var turmas =  turmaRepository.findAll().stream().map(TurmaMapper::convertToDto).collect(Collectors.toList());
		return turmas;
	}

	public TurmaDTO findById(Long id) {
		logger.info("Finding one turma!");
		
		var entity = turmaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = TurmaMapper.convertToDto(entity);
		return vo;
	}
	
	public TurmaDTO create(TurmaDTO turma) {
		//if(turma == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one turma!");
		var entity = TurmaMapper.convertToModel(turma);
		var vo = TurmaMapper.convertToDto(turmaRepository.save(entity));
		return vo;
	}

	
	public TurmaDTO update(TurmaDTO turma) {
		//if(turma == null) throw new RequiredObjectIsNullException();
		logger.info("Update one turma!");
		Turma entity = turmaRepository.findById(turma.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(turma.id());
        entity.setNome(turma.nome());
        entity.setAtividades(turma.atividades());
        entity.setAlunos(turma.alunos());
        entity.setDataFim(turma.dataFim());
        entity.setDataInicio(turma.dataInicio());
        entity.setPeriodo(turma.periodo());
		
		var vo = TurmaMapper.convertToDto(turmaRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one turma!");
	    var entity = turmaRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    turmaRepository.delete(entity);
	}
	
}
