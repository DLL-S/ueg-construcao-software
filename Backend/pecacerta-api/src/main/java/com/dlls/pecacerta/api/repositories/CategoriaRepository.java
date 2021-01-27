package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findByNomeIgnoreCase(String name);

}
