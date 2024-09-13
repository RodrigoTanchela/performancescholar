package com.performancescholar.service;

import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.professor.ProfessorRequestDTO;
import com.performancescholar.dto.professor.ProfessorResponseDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.ProfessorMapper;
import com.performancescholar.model.Professor;
import com.performancescholar.repository.ProfessorRepository;

@Service
public class ProfessorService {
	private Logger logger = Logger.getLogger(ProfessorService.class.getName());
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<ProfessorResponseDTO> findAll() {
		logger.info("Finding all people");
		var professors =  professorRepository.findAll().stream().map(ProfessorMapper::convertToDto).collect(Collectors.toList());
		return professors;
	}

	public ProfessorResponseDTO findById(Long id) {
		logger.info("Finding one professor!");
		
		var entity = professorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = ProfessorMapper.convertToDto(entity);
		return vo;
	}
	
	public ProfessorResponseDTO create(ProfessorRequestDTO professor) {
		//if(professor == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one professor!");
		var entity = ProfessorMapper.convertToModel(professor);
		var vo = ProfessorMapper.convertToDto(professorRepository.save(entity));
		return vo;
	}

	
	public ProfessorResponseDTO update(ProfessorRequestDTO professor) {
		//if(professor == null) throw new RequiredObjectIsNullException();
		logger.info("Update one professor!");
		Professor entity = professorRepository.findById(professor.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(professor.id());
        entity.setNome(professor.nome());
        entity.setEmail(professor.email());
        entity.setSenha(professor.senha());
        entity.setPapel(professor.papel());
        entity.setDataDeCriacao(professor.dataDeCriacao());
        entity.setAtivo(professor.ativo());
        entity.setEspecialidade(professor.especialidade());
		
		var vo = ProfessorMapper.convertToDto(professorRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one professor!");
	    var entity = professorRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    professorRepository.delete(entity);
	}
	
}
