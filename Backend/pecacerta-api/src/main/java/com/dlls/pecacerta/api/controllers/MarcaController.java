package com.dlls.pecacerta.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.exceptions.ResourceNotFoundException;
import com.dlls.pecacerta.api.model.Marca;
import com.dlls.pecacerta.api.repositories.MarcaRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class MarcaController {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	
	@PostMapping("marcas")
	public Marca incluirMarca(@Validated @RequestBody Marca marca) {
		return this.marcaRepository.save(marca);
	}
	
	@PutMapping("marcas/{id}")
	public ResponseEntity<Marca> alterarMarca(@PathVariable(value = "id") Long marcaId,
			@Validated @RequestBody Marca marcaParam) throws ResourceNotFoundException {
		
		Marca marca = marcaRepository.findById(marcaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma marca encontrada pelo código fornecido" + marcaId));
		
		marca.setNome(marcaParam.getNome());
		
		return ResponseEntity.ok(this.marcaRepository.save(marca));
	}
	
	
	@DeleteMapping("marcas/{id}")
	public Map<String, Boolean> excluirCategoria(@PathVariable(value = "id") Long marcaId) throws ResourceNotFoundException {
		Marca marca = marcaRepository.findById(marcaId)
				.orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado pelo id " + marcaId));
		
		this.marcaRepository.delete(marca);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Marca Excluída", true);
		
		return response;
	}
	
	@GetMapping("marcas/{id}")
	public ResponseEntity<Marca>  consultarMarca(@PathVariable(value = "id") Long marcaId) throws ResourceNotFoundException {
	
		Marca marca = marcaRepository.findById(marcaId)
				.orElseThrow(() -> new ResourceNotFoundException("Esta marca não foi encontrad pelo codigo " + marcaId));
	
		return ResponseEntity.ok().body(marca);
	}
	
	@GetMapping("marcas")
	public List<Marca> listarMarcas() {
		
		return this.marcaRepository.findAll();
	}

}
