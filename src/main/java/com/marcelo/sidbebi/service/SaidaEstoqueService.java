package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.SaidaEstoque;
import com.marcelo.sidbebi.domain.dtos.SaidaEstoqueDTO;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.repositories.SaidaEstoqueRespository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class SaidaEstoqueService {
	
	@Autowired
	private SaidaEstoqueRespository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public SaidaEstoque findById(Integer id) {
		Optional<SaidaEstoque> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public List<SaidaEstoque> findAll() {
		return repository.findAll();
	}
	
	public SaidaEstoque create(SaidaEstoqueDTO objDTO) {
		objDTO.setId(null);		
		SaidaEstoque newObj = new SaidaEstoque();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}
	
	public SaidaEstoque atualizaEstoqueSaida(Integer id, SaidaEstoqueDTO objDTO) {		
		objDTO.setId(id);
		Optional<Produto> obj = produtoRepository.findByNome(objDTO.getProduto());
		obj.get().setQtd(obj.get().getQtd() - objDTO.getQtd());
		obj.get().setNivel(produtoService.nivelEstoque(obj.get().getQtd()));
		produtoRepository.save(obj.get());
		SaidaEstoque newObj = new SaidaEstoque();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}
	
}
