package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.ItensAgendamento;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.dtos.ItensAgendamentoDTO;
import com.marcelo.sidbebi.repositories.AgendamentoRepository;
import com.marcelo.sidbebi.repositories.ItensAgendamentoRepository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class ItensAgendamentoService {
	
	@Autowired
	private ItensAgendamentoRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public ItensAgendamento findById(Integer id) {
		Optional<ItensAgendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public ItensAgendamento create(ItensAgendamentoDTO objDTO) {
		objDTO.setId(null);
		Optional<Produto> produto = produtoRepository.findByNome(objDTO.getItem());
		objDTO.setValorUnit(produto.get().getValorUnit());
		objDTO.setSubTotal(objDTO.getSubTotal() + (objDTO.getQuantidade() * objDTO.getValorUnit()));
		Optional<Agendamento> agendamento = agendamentoRepository.findById(objDTO.getAgendamento().getId());		
		agendamento.get().setValorTotal(agendamento.get().getValorTotal() + objDTO.getSubTotal());
		agendamentoRepository.save(agendamento.get());	
		objDTO.setAgendamento(agendamento.get());
		ItensAgendamento newObjItens = new ItensAgendamento();
		BeanUtils.copyProperties(objDTO, newObjItens);
		return repository.save(newObjItens);
	}	
	
	public List<ItensAgendamento> findAll() {
		return repository.findAll();
	}

	public ItensAgendamento update(Integer id, ItensAgendamentoDTO objDTO) {
		objDTO.setId(id);
		ItensAgendamento oldObj = findById(id);
		oldObj = new ItensAgendamento();
		BeanUtils.copyProperties(objDTO, oldObj);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		ItensAgendamento obj = findById(id);
		repository.deleteById(id);
	}

}
