package com.performancescholar.mapper;

import com.performancescholar.dto.administrador.AdministradorRequestDTO;
import com.performancescholar.dto.administrador.AdministradorResponseDTO;
import com.performancescholar.model.Administrador;

public class AdministradorMapper {
	
	public static AdministradorResponseDTO convertToDto(Administrador aluno) {
		AdministradorResponseDTO administradorDto = new AdministradorResponseDTO(aluno.getNome(), aluno.getEmail(), aluno.getTipo(), 
				aluno.getDataCriacao(), aluno.getAtivo());
		return administradorDto;
	}
	
	public static Administrador convertToModel(AdministradorRequestDTO administradorDto) {
		 if (administradorDto == null) {
	            return null;
	        }

	        Administrador entity = new Administrador();
	        entity.setId(administradorDto.id());
	        entity.setNome(administradorDto.nome());
	        entity.setEmail(administradorDto.email());
	        entity.setSenha(administradorDto.senha());
	        entity.setTipo(administradorDto.tipo());
	        entity.setDataCriacao(administradorDto.dataCriacao());
	        entity.setAtivo(administradorDto.ativo());
			
	        return entity;
	}
}