package com.marcelo.sidbebi.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Estoque;
import com.marcelo.sidbebi.repositories.EstoqueRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;
	
	public Estoque findById(Integer id) {
		Optional<Estoque> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
}
