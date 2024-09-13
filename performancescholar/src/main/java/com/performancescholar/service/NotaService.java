package com.performancescholar.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.nota.NotaDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.NotaMapper;
import com.performancescholar.model.Nota;
import com.performancescholar.repository.NotaRepository;

@Service
public class NotaService {
	private Logger logger = Logger.getLogger(NotaService.class.getName());
	
	@Autowired
	private NotaRepository notaRepository;
	
	public List<NotaDTO> findAll() {
		logger.info("Finding all people");
		var notas =  notaRepository.findAll().stream().map(NotaMapper::convertToDto).collect(Collectors.toList());
		return notas;
	}

	public NotaDTO findById(Long id) {
		logger.info("Finding one nota!");
		
		var entity = notaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = NotaMapper.convertToDto(entity);
		return vo;
	}
	
	public NotaDTO create(NotaDTO nota) {
		//if(nota == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one nota!");
		var entity = NotaMapper.convertToModel(nota);
		var vo = NotaMapper.convertToDto(notaRepository.save(entity));
		return vo;
	}

	
	public NotaDTO update(NotaDTO nota) {
		//if(nota == null) throw new RequiredObjectIsNullException();
		logger.info("Update one nota!");
		Nota entity = notaRepository.findById(nota.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(nota.id());
        entity.setValor(nota.valor());
        entity.setDataRegistro(nota.dataRegistro());
        entity.setAluno(nota.aluno());
        entity.setAtividade(nota.atividade());
		
		var vo = NotaMapper.convertToDto(notaRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one nota!");
	    var entity = notaRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    notaRepository.delete(entity);
	}
}
