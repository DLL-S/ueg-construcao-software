package com.dlls.pecacerta.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return funcionarios.isEmpty() ? 
				ResponseEntity.noContent().build() : ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> getById(@PathVariable Long codigo) {
		Optional<Funcionario> funcionarios = funcionarioRepository.findById(codigo); 
		return funcionarios.isEmpty() ? 
				ResponseEntity.notFound().build() : ResponseEntity.ok(funcionarios);
	}
}
