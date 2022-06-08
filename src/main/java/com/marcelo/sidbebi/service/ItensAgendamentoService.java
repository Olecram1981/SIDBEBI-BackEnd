package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensAgendamento;
import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.dtos.AgendamentoDTO;
import com.marcelo.sidbebi.domain.dtos.ItensAgendamentoDTO;
import com.marcelo.sidbebi.repositories.AgendamentoRepository;
import com.marcelo.sidbebi.repositories.ClienteRepository;
import com.marcelo.sidbebi.repositories.ItensAgendamentoRepository;
import com.marcelo.sidbebi.repositories.ItensProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class ItensAgendamentoService {
	
	@Autowired
	private ItensAgendamentoRepository repository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ItensProdutoRepository itensProdutoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ItensAgendamento findById(Integer id) {
		Optional<ItensAgendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public Agendamento create(AgendamentoDTO agendamentoDTO) {
		Optional<Cliente> cliente = clienteRepository.findById(agendamentoDTO.getCliente());
		Agendamento agendamento = new Agendamento();		
		BeanUtils.copyProperties(agendamentoDTO, agendamento);
		agendamento.setCliente(cliente.get());	
		agendamento.setNomeCliente(cliente.get().getNome());
		agendamento.setPagamento(agendamentoDTO.getPagamento());
		agendamento.setStatus(agendamentoDTO.getStatus());
		agendamento = agendamentoRepository.save(agendamento);
		
		for(int x = 0; x < agendamentoDTO.getItensAgendamento().length; x++){						
			ItensAgendamento itensAgendamento = new ItensAgendamento();
			Optional<ItensProduto> itensProduto = itensProdutoRepository.findByCodBarra(agendamentoDTO.getItensAgendamento()[x]);
			itensAgendamento.setCodBarra(itensProduto.get().getCodBarra());
			itensAgendamento.setValorUnit(itensProduto.get().getProduto().getValorUnit());			
			itensAgendamento.setItem(itensProduto.get().getProduto().getNome());
			itensAgendamento.setAgendamento(agendamento);				
			repository.save(itensAgendamento);			
		}
		
		return agendamento;
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
		@SuppressWarnings("unused")
		ItensAgendamento obj = findById(id);
		repository.deleteById(id);
	}

}
