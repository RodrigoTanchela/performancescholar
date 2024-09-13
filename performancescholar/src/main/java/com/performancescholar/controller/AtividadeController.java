package com.performancescholar.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.performancescholar.dto.nota.NotaDTO;
import com.performancescholar.service.NotaService;

@RestController
@RequestMapping("/nota")
public class AtividadeController {
	@Autowired
	private NotaService service;
	
	@GetMapping
	public List<NotaDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public NotaDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public NotaDTO create(@RequestBody NotaDTO nota) {
		return service.create(nota);
	}
	
	@PutMapping
	public NotaDTO update(@RequestBody NotaDTO nota) {
		return service.update(nota);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
