package com.dlls.pecacerta.api.controller;

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
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//Métodos do Crud
	
	@PostMapping("produto")
	public Produto incluirProduto(@Validated @RequestBody Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	@PutMapping("produto/{id}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable(value = "id") Long produtoId,
			@Validated @RequestBody Produto produtoParam) throws ResourceNotFoundException {
		
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código: " + produtoId));
		
		produto.setNome(produtoParam.getNome());
		produto.setDescricao(produtoParam.getDescricao());
		produto.setCategoria(produtoParam.getCategoria());
		produto.setMarca(produtoParam.getMarca());
		produto.setPreco(produtoParam.getPreco());
		produto.setQtdeEstoque(produtoParam.getQtdeEstoque());
		
		return ResponseEntity.ok(this.produtoRepository.save(produto));
	}
	
	@DeleteMapping("produto/{id}")
	public Map<String, Boolean> excluirProduto(@PathVariable(value = "id") Long produtoId) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código " + produtoId));
		
		this.produtoRepository.delete(produto);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Produto Excluído", true);
		
		return response;
	}
	
	@GetMapping("produto/{id}")
	public ResponseEntity<Produto>  consultarProduto(@PathVariable(value = "id") Long produtoId) throws ResourceNotFoundException {
	
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código: " + produtoId));
	
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping("produtos")
	public List<Produto> listarProdutos() {
		return this.produtoRepository.findAll();
	}

}
