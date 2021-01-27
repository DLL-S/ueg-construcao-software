package com.dlls.pecacerta.api.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.model.Marca;
import com.dlls.pecacerta.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByNomeContainingIgnoreCase(String name);	
	List<Produto> findByNomeIgnoreCase(String name);	
	List<Produto> findByCategoria(Categoria categoria);	
	List<Produto> findByMarca(Marca marca);	
	
}
