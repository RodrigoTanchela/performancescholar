package com.performancescholar.service;

import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.aluno.AlunoRequestDTO;
import com.performancescholar.dto.aluno.AlunoResponseDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.AlunoMapper;
import com.performancescholar.model.Aluno;
import com.performancescholar.repository.AlunoRepository;

@Service
public class AlunoService {
	private Logger logger = Logger.getLogger(AlunoService.class.getName());
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AlunoResponseDTO> findAll() {
		logger.info("Finding all people");
		var alunos =  alunoRepository.findAll().stream().map(AlunoMapper::convertToDto).collect(Collectors.toList());
		return alunos;
	}

	public AlunoResponseDTO findById(Long id) {
		logger.info("Finding one aluno!");
		
		var entity = alunoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = AlunoMapper.convertToDto(entity);
		return vo;
	}
	
	public AlunoResponseDTO create(AlunoRequestDTO aluno) {
		//if(aluno == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one aluno!");
		var entity = AlunoMapper.convertToModel(aluno);
		var vo = AlunoMapper.convertToDto(alunoRepository.save(entity));
		return vo;
	}

	
	public AlunoResponseDTO update(AlunoRequestDTO aluno) {
		//if(aluno == null) throw new RequiredObjectIsNullException();
		logger.info("Update one aluno!");
		Aluno entity = alunoRepository.findById(aluno.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(aluno.id());
        entity.setNome(aluno.nome());
        entity.setEmail(aluno.email());
        entity.setSenha(aluno.senha());
        entity.setPapel(aluno.papel());
        entity.setDataDeCriacao(aluno.dataDeCriacao());
        entity.setAtivo(aluno.ativo());
        entity.setMatricula(aluno.matricula());
		
		var vo = AlunoMapper.convertToDto(alunoRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one aluno!");
	    var entity = alunoRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    alunoRepository.delete(entity);
	}
	
}
