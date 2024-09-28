package com.performancescholar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.performancescholar.dto.administrador.AdministradorRequestDTO;
import com.performancescholar.dto.administrador.AdministradorResponseDTO;
import com.performancescholar.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
	@Autowired
	private AdministradorService service;
	
	@GetMapping
	public List<AdministradorResponseDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public AdministradorResponseDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:5173")
	public AdministradorResponseDTO create(@RequestBody AdministradorRequestDTO administrador) {
		return service.create(administrador);
	}
	
	@PutMapping
	public AdministradorResponseDTO update(@RequestBody AdministradorRequestDTO administrador) {
		return service.update(administrador);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}
}
