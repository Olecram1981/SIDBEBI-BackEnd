package com.marcelo.sidbebi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.repositories.ClienteRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	//istancia e persiste os objetos no Banco de Dados
	public void instanciaDB() { 
		Cliente cli1 = new Cliente(null, "Marcelo Machado", "88519090168", null, "9282 2316", "Rua Ferando de Noronha", "marcelo@mail.com");
		
		clienteRepository.saveAll(Arrays.asList(cli1));
	}
	
}
