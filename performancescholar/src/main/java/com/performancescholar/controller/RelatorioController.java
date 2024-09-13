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

import com.performancescholar.dto.relatorio.RelatorioDTO;
import com.performancescholar.service.RelatorioService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioService service;
	
	@GetMapping
	public List<RelatorioDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public RelatorioDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public RelatorioDTO create(@RequestBody RelatorioDTO relatorio) {
		return service.create(relatorio);
	}
	
	@PutMapping
	public RelatorioDTO update(@RequestBody RelatorioDTO relatorio) {
		return service.update(relatorio);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
