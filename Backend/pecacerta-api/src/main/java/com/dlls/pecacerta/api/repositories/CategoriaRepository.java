package com.dlls.pecacerta.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
