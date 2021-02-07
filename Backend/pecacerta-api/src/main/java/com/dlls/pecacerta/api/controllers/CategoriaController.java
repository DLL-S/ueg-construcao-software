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
import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.repositories.CategoriaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@PostMapping("categoria")
	public Categoria incluirCategoria(@Validated @RequestBody Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
	@PutMapping("categoria/{id}")
	public ResponseEntity<Categoria> alterarCategoria(@PathVariable(value = "id") Long categoriaId,
			@Validated @RequestBody Categoria categoriaParam) throws ResourceNotFoundException {
		
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrada pelo código " + categoriaId));
		
		categoria.setNome(categoriaParam.getNome());
		
		return ResponseEntity.ok(this.categoriaRepository.save(categoria));
	}
	
	
	@DeleteMapping("categoria/{id}")
	public Map<String, Boolean> excluirCategoria(@PathVariable(value = "id") Long categoriaId) throws ResourceNotFoundException {
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrada pelo código " + categoriaId));
		
		this.categoriaRepository.delete(categoria);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Categoria Excluída", true);
		
		return response;
	}
	
	@GetMapping("categoria/{id}")
	public ResponseEntity<Categoria>  consultarCategoria(@PathVariable(value = "id") Long categoriaId) throws ResourceNotFoundException {
	
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Esta categoria não foi encontrada pelo codigo " + categoriaId));
	
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping("categoria")
	public List<Categoria> listarCategorias() {
		
		return this.categoriaRepository.findAll();
	}


}
