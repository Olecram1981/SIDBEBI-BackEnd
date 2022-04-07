package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.RelatorioDTO;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.repositories.ItensVendaRepository;
import com.marcelo.sidbebi.repositories.VendaRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ItensVendaService itensVendaService;
	
	public Venda findById(Integer id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	
	public List<Venda> findAll() {
		return repository.findAll();
	}
	
	public Venda create(VendaDTO objDTO) {
		objDTO.setId(null);
		Venda newObj = new Venda();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}	

	public Venda update(Integer id, VendaDTO objDTO) {
		objDTO.setId(id);
		Venda oldObj = findById(id);
		oldObj = new Venda();
		BeanUtils.copyProperties(objDTO, oldObj);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Venda obj = findById(id);
		repository.deleteById(id);
	}
	
}
