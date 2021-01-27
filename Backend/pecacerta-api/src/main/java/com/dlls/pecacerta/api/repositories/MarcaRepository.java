package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
	
	public List<Marca> findByNomeIgnoreCase(String name);


}
