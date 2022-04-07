package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.Relatorio;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.domain.dtos.RelatorioDTO;
import com.marcelo.sidbebi.repositories.ItensVendaRepository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.repositories.VendaRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class ItensVendaService {
	
	@Autowired
	private ItensVendaRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public ItensVenda findById(Integer id) {
		Optional<ItensVenda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public Relatorio findByItem(RelatorioDTO objDTO) {
		List<ItensVenda> obj = repository.findByItem(objDTO.getItem());
		objDTO.setQtdTotal(0);
		objDTO.setValorTotal(0);
		for(ItensVenda itens : obj) {
			objDTO.setQtdTotal(objDTO.getQtdTotal() + itens.getQuantidade());
			objDTO.setValorTotal(objDTO.getValorTotal() + itens.getSubTotal());
		}
		Relatorio relatorio = new Relatorio();
		BeanUtils.copyProperties(objDTO, relatorio);
		return relatorio;
	}
	
	public ItensVenda create(ItensVendaDTO objItensDTO) {
		objItensDTO.setId(null);
		Optional<Produto> produto = produtoRepository.findByNome(objItensDTO.getItem());
		objItensDTO.setValorUnit(produto.get().getValorUnit());
		objItensDTO.setSubTotal(objItensDTO.getQuantidade() * objItensDTO.getValorUnit());
		Optional<Venda> venda = vendaRepository.findById(objItensDTO.getVenda().getId());		
		venda.get().setValorTotal(venda.get().getValorTotal() + objItensDTO.getSubTotal());
		vendaRepository.save(venda.get());	
		objItensDTO.setVenda(venda.get());	
		produto.get().setQtd(produto.get().getQtd() - objItensDTO.getQuantidade());
		produtoRepository.save(produto.get());
		ItensVenda newObjItens = new ItensVenda();
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
