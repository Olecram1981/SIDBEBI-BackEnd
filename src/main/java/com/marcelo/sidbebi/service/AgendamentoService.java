package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensAgendamento;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.AgendamentoDTO;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.domain.enums.Status;
import com.marcelo.sidbebi.repositories.AgendamentoRepository;
import com.marcelo.sidbebi.repositories.ClienteRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ItensVendaService itensVendaService;
	
	public Agendamento findById(Integer id) {
		Optional<Agendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public List<Agendamento> findAll() {
		return repository.findAll();
	}

	public Agendamento create(AgendamentoDTO objDTO) {
		objDTO.setId(null);
		Agendamento newObj = new Agendamento();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}	

	public Agendamento update(Integer id, AgendamentoDTO objDTO) {		
		if(objDTO.getStatus() == Status.ENTREGUE) {
			Optional<Cliente> cliente = clienteRepository.findByNome(objDTO.getNomeCliente());
			Venda venda = new Venda();
			venda.setCliente(cliente.get());
			venda.setPagamento(objDTO.getPagamento());
			venda.setNomeCliente(objDTO.getNomeCliente());
			VendaDTO vendaDTO = new VendaDTO();
			BeanUtils.copyProperties(venda, vendaDTO);
			venda =	vendaService.create(vendaDTO);
			Agendamento agendamento = findById(id);
			List<ItensAgendamento> itensAgendamento = agendamento.getItens();
			agendamento.setValorTotal(0);
			ItensVenda itensVenda = new ItensVenda();			
			for(ItensAgendamento item : itensAgendamento) {
				itensVenda.setId(item.getId());
				itensVenda.setItem(item.getItem());
				itensVenda.setSubTotal(item.getSubTotal());
				itensVenda.setValorUnit(item.getValorUnit());
				itensVenda.setVenda(venda);
				ItensVendaDTO itensVendaDTO = new ItensVendaDTO();
				BeanUtils.copyProperties(itensVenda, itensVendaDTO);
				itensVendaService.create(itensVendaDTO);
				agendamento.setValorTotal(agendamento.getValorTotal() + item.getSubTotal());
				agendamento.setStatus(Status.ENTREGUE);
			} 
			return repository.save(agendamento);
		}
		else {
			objDTO.setId(id);
			Agendamento oldObj = findById(id);
			oldObj = new Agendamento();
			BeanUtils.copyProperties(objDTO, oldObj);
			return repository.save(oldObj);
		}
	}

	public void delete(Integer id) {
		Agendamento obj = findById(id);
		repository.deleteById(id);
	}
	
}
