package com.dlls.pecacerta.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;
import com.dlls.pecacerta.api.services.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
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
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response) {
		Funcionario savedFuncionario = funcionarioService.save(funcionario);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedFuncionario.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFuncionario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
		Funcionario savedFuncionario = funcionarioService.update(id, funcionario);
		return ResponseEntity.ok(savedFuncionario);
	}
}
