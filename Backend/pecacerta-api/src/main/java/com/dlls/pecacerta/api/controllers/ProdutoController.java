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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.exceptions.ResourceNotFoundException;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.CategoriaRepository;
import com.dlls.pecacerta.api.repositories.MarcaRepository;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private MarcaRepository marcaRepository;
	
	//***Métodos do Crud***//
	
	//Insert Product
	@PostMapping("produto")
	public Produto incluirProduto(@Validated @RequestBody Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	//Alter Product
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
	
	//Delete Product
	@DeleteMapping("produto/{id}")
	public Map<String, Boolean> excluirProduto(@PathVariable(value = "id") Long produtoId) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código " + produtoId));
		
		this.produtoRepository.delete(produto);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Produto Excluído", true);
		
		return response;
	}
	
	//Search Product by ID
	@GetMapping("produto/{id}")
	public ResponseEntity<Produto>  consultarProduto(@PathVariable(value = "id") Long produtoId) throws ResourceNotFoundException {
	
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código: " + produtoId));
	
		return ResponseEntity.ok().body(produto);
	}
	
	//Search Product by part of name
	@GetMapping("produto/procurar/parte-do-nome") 
	public List<Produto> findByPartOfName(@RequestParam("nome") String name) {
		return this.produtoRepository.findByNomeContainingIgnoreCase(name); 
	}
	
	//Search Product by name
	@GetMapping("produto/procurar/nome") 
	public List<Produto> findByName(@RequestParam("nome") String name) {
		return this.produtoRepository.findByNomeIgnoreCase(name); 
	}
	
	//Search Product by Category
	@GetMapping("produto/procurar/categoria") 
	public List<Produto> findByCategory(@RequestParam("nome") String categoria) {
		var cat = categoriaRepository.findByNomeIgnoreCase(categoria).stream().findFirst().get();
		return this.produtoRepository.findByCategoria(cat);
	}
	
	//Search Product by Marca
	@GetMapping("produto/procurar/marca") 
	public List<Produto> findByMarca(@RequestParam("nome") String marca) {
		var mar = marcaRepository.findByNomeIgnoreCase(marca).stream().findFirst().get();
		return this.produtoRepository.findByMarca(mar);
	}
	
	//List of all products
	@GetMapping("produtos")
	public List<Produto> listarProdutos() {
		return this.produtoRepository.findAll();
	}

}
