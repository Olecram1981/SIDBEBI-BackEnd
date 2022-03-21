package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.dtos.EntradaEstoqueDTO;
import com.marcelo.sidbebi.domain.dtos.ProdutoDTO;
import com.marcelo.sidbebi.repositories.EntradaEstoqueRespository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public Produto findByNome(ProdutoDTO produto) {
		Optional<Produto> obj = repository.findByNome(produto.getNome());
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado: "+produto.getNome()));
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto create(ProdutoDTO objDTO) {			
		objDTO.setId(null);
		Produto produto = new Produto();
		BeanUtils.copyProperties(objDTO, produto);
		return repository.save(produto);
	}

	public Produto update(Integer id, ProdutoDTO objDTO) {
		objDTO.setId(id);
		Produto oldObj = findById(id);
		oldObj = new Produto();
		BeanUtils.copyProperties(objDTO, oldObj);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Produto obj = findById(id);
		repository.deleteById(id);
	}

}
