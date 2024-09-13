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

import com.performancescholar.dto.aluno.AlunoRequestDTO;
import com.performancescholar.dto.aluno.AlunoResponseDTO;
import com.performancescholar.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public List<AlunoResponseDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public AlunoResponseDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public AlunoResponseDTO create(@RequestBody AlunoRequestDTO aluno) {
		return service.create(aluno);
	}
	
	@PutMapping
	public AlunoResponseDTO update(@RequestBody AlunoRequestDTO aluno) {
		return service.update(aluno);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}
}
