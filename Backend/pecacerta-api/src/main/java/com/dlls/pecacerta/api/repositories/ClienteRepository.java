package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlls.pecacerta.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public List<Cliente> findByCpfCnpj(String cpfCnpj);
}