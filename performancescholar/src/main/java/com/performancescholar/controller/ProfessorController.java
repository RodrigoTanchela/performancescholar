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

import com.performancescholar.dto.professor.ProfessorRequestDTO;
import com.performancescholar.dto.professor.ProfessorResponseDTO;
import com.performancescholar.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public List<ProfessorResponseDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ProfessorResponseDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:5173")
	public ProfessorResponseDTO create(@RequestBody ProfessorRequestDTO professor) {
		return service.create(professor);
	}
	
	@PutMapping
	public ProfessorResponseDTO update(@RequestBody ProfessorRequestDTO professor) {
		return service.update(professor);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}
}
