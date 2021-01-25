package com.dlls.pecacerta.api.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.exceptions.ClienteAlreadyExistsException;
import com.dlls.pecacerta.api.exceptions.ClienteNoneExistentException;
import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente findCliente(Integer codigo) {
		Cliente savedPerson = clienteRepository.findById(codigo)
				.orElseThrow(() -> new ClienteNoneExistentException());
		return savedPerson;
	}

	public Cliente save(@Valid Cliente cliente) {
		if (!clienteRepository.findByCpf_cnpj(cliente.getCpf_cnpj()).isEmpty())
			throw new ClienteAlreadyExistsException();

		return clienteRepository.save(cliente);
	}

	public Cliente update(Integer codigo, @Valid Cliente updatedCliente) {
		Cliente savedCliente = findCliente(codigo);
		
		List<Cliente> clienteComMesmoCpf = clienteRepository.findByCpf_cnpj(updatedCliente.getCpf_cnpj());
		if(!clienteComMesmoCpf.isEmpty()) {
			for (Cliente cliente : clienteComMesmoCpf) {
				if(cliente.getCodigo() != savedCliente.getCodigo())
					throw new ClienteAlreadyExistsException();
			}
		}

		BeanUtils.copyProperties(updatedCliente, savedCliente, "codigo");
		return clienteRepository.save(savedCliente);
	}
}
