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

import com.performancescholar.dto.turma.TurmaDTO;
import com.performancescholar.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService service;
	
	@GetMapping
	public List<TurmaDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public TurmaDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public TurmaDTO create(@RequestBody TurmaDTO turma) {
		return service.create(turma);
	}
	
	@PutMapping
	public TurmaDTO update(@RequestBody TurmaDTO turma) {
		return service.update(turma);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
