package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.dtos.ClienteDTO;
import com.marcelo.sidbebi.repositories.ClienteRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;
import com.valdir.helpdesk.domain.Tecnico;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		repository.deleteById(id);
	}

}
