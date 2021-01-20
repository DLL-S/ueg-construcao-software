package com.dlls.pecacerta.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("produtos")
	public List<Produto> listarProdutos() {
		return this.produtoRepository.findAll();
	}

}
