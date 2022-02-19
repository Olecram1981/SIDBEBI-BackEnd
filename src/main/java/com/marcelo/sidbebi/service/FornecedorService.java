package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Estoque;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.dtos.FornecedorDTO;
import com.marcelo.sidbebi.repositories.FornecedorRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	@Autowired
	private EstoqueService service;
	
	public Fornecedor findById(Integer id) {
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}

	public List<Fornecedor> findAll() {
		return repository.findAll();
	}
	
	public Fornecedor create(FornecedorDTO objDTO) {			
		objDTO.setId(null);
		Estoque estoque = service.findById(objDTO.getEstoque());
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setEstoque(estoque);
		fornecedor.setId(objDTO.getId());
		fornecedor.setNome(objDTO.getNome());
		fornecedor.setCpfCnpj(objDTO.getCpfCnpj());
		fornecedor.setEnd(objDTO.getEnd());
		fornecedor.setTelefone(objDTO.getTelefone());
		fornecedor.setEmail(objDTO.getEmail());
		
		return repository.save(fornecedor);
	}
	
}
