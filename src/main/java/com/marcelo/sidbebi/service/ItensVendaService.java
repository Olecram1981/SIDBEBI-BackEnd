package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.repositories.ItensVendaRepository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class ItensVendaService {
	
	@Autowired
	private ItensVendaRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ItensVenda findById(Integer id) {
		Optional<ItensVenda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public ItensVenda create(ItensVendaDTO objItensDTO) {		
		ItensVenda newObjItens = new ItensVenda();
		Optional<Produto> produto = produtoRepository.findByNome(objItensDTO.getItem());
		objItensDTO.setValorUnit(produto.get().getValorUnit());
		BeanUtils.copyProperties(objItensDTO, newObjItens);
		return repository.save(newObjItens);
	}	
	
	public List<ItensVenda> findAll() {
		return repository.findAll();
	}

	public ItensVenda update(Integer id, ItensVendaDTO objDTO) {
		objDTO.setId(id);
		ItensVenda oldObj = findById(id);
		oldObj = new ItensVenda();
		BeanUtils.copyProperties(objDTO, oldObj);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		ItensVenda obj = findById(id);
		repository.deleteById(id);
	}

}
