package com.dlls.pecacerta.api.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

	public Funcionario findFuncionario(Long codigo) {
		Funcionario savedPerson = funcionarioRepository.findById(codigo)
				.orElseThrow(() -> new FuncionarioNonexistentException());
		return savedPerson;
	}

	public Funcionario save(@Valid Funcionario funcionario) {
		if (!funcionarioRepository.findByCpf(funcionario.getCpf()).isEmpty())
			throw new FuncionarioAlreadyExistsException();

		return funcionarioRepository.save(funcionario);
	}

	public Funcionario update(Long codigo, @Valid Funcionario updatedFuncionario) {
		Funcionario savedFuncionario = findFuncionario(codigo);
		
		List<Funcionario> funcionarioComMesmoCpf = funcionarioRepository.findByCpf(updatedFuncionario.getCpf());
		if(!funcionarioComMesmoCpf.isEmpty()) {
			for (Funcionario funcionario : funcionarioComMesmoCpf) {
				if(funcionario.getCodigo() != savedFuncionario.getCodigo())
					throw new FuncionarioAlreadyExistsException();
			}
		}

		BeanUtils.copyProperties(updatedFuncionario, savedFuncionario, "codigo");
		return funcionarioRepository.save(savedFuncionario);
	}
}
