package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.dtos.ItensProdutoDTO;
import com.marcelo.sidbebi.repositories.ItensProdutoRepository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class ItensProdutoService {
	
	@Autowired
	private ItensProdutoRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ItensProduto findById(Integer id) {
		Optional<ItensProduto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}

	public List<ItensProduto> findAll() {
		return repository.findAll();
	}

	public ItensProduto create(ItensProdutoDTO objDTO) {
		objDTO.setId(null);
		Optional<Produto> produto = produtoRepository.findById(objDTO.getProduto().getId());
		produto.get().setQtd(produto.get().getQtd() + 1);
		produto.get().setValorTotal(produto.get().getValorUnit() * produto.get().getQtd());
		produtoRepository.save(produto.get());
		ItensProduto newObj = new ItensProduto();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}	

	public ItensProduto update(Integer id, ItensProdutoDTO objDTO) {
		objDTO.setId(id);
		ItensProduto oldObj = findById(id);
		oldObj = new ItensProduto();
		BeanUtils.copyProperties(objDTO, oldObj);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produto.get().setQtd(produto.get().getQtd() - 1);
		produto.get().setValorTotal(produto.get().getValorUnit() * produto.get().getQtd());
		produtoRepository.save(produto.get());
		ItensProduto obj = findById(id);
		repository.deleteById(id);
	}
	
}