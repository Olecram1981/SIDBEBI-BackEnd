package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.dtos.EntradaEstoqueDTO;
import com.marcelo.sidbebi.repositories.EntradaEstoqueRespository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class EntradaEstoqueService {
	
	@Autowired
	private EntradaEstoqueRespository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public EntradaEstoque findById(Integer id) {
		Optional<EntradaEstoque> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public List<EntradaEstoque> findAll() {
		return repository.findAll();
	}
	
	public EntradaEstoque create(EntradaEstoqueDTO objDTO) {
		objDTO.setId(null);		
		EntradaEstoque newObj = new EntradaEstoque();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}
	
	public EntradaEstoque atualizaEstoqueEntrada(Integer id, EntradaEstoqueDTO objDTO) {		
		objDTO.setId(id);
		Optional<Produto> obj = produtoRepository.findByNome(objDTO.getProduto());
		obj.get().setQtd(obj.get().getQtd() + objDTO.getQtd());
		obj.get().setValorUnit(objDTO.getValor());
		obj.get().setNivel(produtoService.nivelEstoque(obj.get().getQtd()));
		produtoRepository.save(obj.get());
		EntradaEstoque newObj = new EntradaEstoque();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}
	
}
