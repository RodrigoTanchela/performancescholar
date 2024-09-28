package com.performancescholar.service;

import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.performancescholar.dto.administrador.AdministradorRequestDTO;
import com.performancescholar.dto.administrador.AdministradorResponseDTO;
import com.performancescholar.exceptions.ResourceNotFoundExcpetion;
import com.performancescholar.mapper.AdministradorMapper;
import com.performancescholar.model.Administrador;
import com.performancescholar.repository.AdministradorRepository;

@Service
public class AdministradorService {
	private Logger logger = Logger.getLogger(AdministradorService.class.getName());
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	public List<AdministradorResponseDTO> findAll() {
		logger.info("Finding all people");
		var administradores =  administradorRepository.findAll().stream().map(AdministradorMapper::convertToDto).collect(Collectors.toList());
		return administradores;
	}

	public AdministradorResponseDTO findById(Long id) {
		logger.info("Finding one administrador!");
		
		var entity = administradorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
		var vo = AdministradorMapper.convertToDto(entity);
		return vo;
	}
	
	public AdministradorResponseDTO create(AdministradorRequestDTO administrador) {
		//if(administrador == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one administrador!");
		var entity = AdministradorMapper.convertToModel(administrador);
		var vo = AdministradorMapper.convertToDto(administradorRepository.save(entity));
		return vo;
	}

	
	public AdministradorResponseDTO update(AdministradorRequestDTO administrador) {
		//if(administrador == null) throw new RequiredObjectIsNullException();
		logger.info("Update one administrador!");
		Administrador entity = administradorRepository.findById(administrador.id()).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));
        entity.setId(administrador.id());
        entity.setNome(administrador.nome());
        entity.setEmail(administrador.email());
        entity.setSenha(administrador.senha());
        entity.setTipo(administrador.tipo());
        entity.setDataCriacao(administrador.dataCriacao());
        entity.setAtivo(administrador.ativo());
		
		var vo = AdministradorMapper.convertToDto(administradorRepository.save(entity));
		return vo;
	}
	
	public void delete(Long key) {
		logger.info("Deleting one administrador!");
	    var entity = administradorRepository.findById(key).orElseThrow(()-> new ResourceNotFoundExcpetion("No records Found for this Id"));	
	    administradorRepository.delete(entity);
	}
	
}
