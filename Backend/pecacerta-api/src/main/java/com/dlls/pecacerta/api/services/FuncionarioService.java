package com.dlls.pecacerta.api.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.exceptions.FuncionarioAlreadyExistsException;
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
	
	public Funcionario save(@Valid Funcionario funcionario) {
		if(!funcionarioRepository.findByCpf(funcionario.getCpf()).isEmpty())
			throw new FuncionarioAlreadyExistsException();
		
		return funcionarioRepository.save(funcionario);
	}
}
