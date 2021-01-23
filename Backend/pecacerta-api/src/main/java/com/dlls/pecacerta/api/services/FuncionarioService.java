package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.exceptions.FuncionarioNonexistentException;
import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario findFuncionario(Long id) {
		Funcionario savedPerson = funcionarioRepository.findById(id)
				.orElseThrow(() -> new FuncionarioNonexistentException());
		return savedPerson;
	}
	
	

}
