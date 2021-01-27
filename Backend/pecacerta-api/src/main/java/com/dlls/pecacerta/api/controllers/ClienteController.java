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
import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;
import com.dlls.pecacerta.api.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.isEmpty() ? 
				ResponseEntity.noContent().build() : ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> getById(@PathVariable Long codigo) {
		Optional<Cliente> clientes = clienteRepository.findById(codigo); 
		return clientes.isEmpty() ? 
				ResponseEntity.notFound().build() : ResponseEntity.ok(clientes);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente savedCliente = clienteService.save(cliente);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCliente.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente savedCliente = clienteService.update(id, cliente);
		return ResponseEntity.ok(savedCliente);
	}
}
