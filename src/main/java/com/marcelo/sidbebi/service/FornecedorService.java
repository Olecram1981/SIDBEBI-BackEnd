package com.marcelo.sidbebi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.repositories.FornecedorRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	public Fornecedor findById(Integer id) {
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
}
