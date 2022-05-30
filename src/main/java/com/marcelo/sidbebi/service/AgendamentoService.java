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
	private ItensAgendamentoService itensAgendamentoService;
	
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
		Agendamento agendamento = itensAgendamentoService.create(objDTO);
		return agendamento;
	}	

	public Agendamento update(Integer id, AgendamentoDTO objDTO) {		
		if(objDTO.getStatus() == Status.ENTREGUE) {
			VendaDTO vendaDTO = new VendaDTO();
			vendaDTO.setPagamento(objDTO.getPagamento().getCodigoInteger());
			vendaDTO.setQtdItens(objDTO.getQtdItens());
			vendaDTO.setValorTotal(objDTO.getValorTotal());
			vendaDTO.setItensVenda(objDTO.getItensAgendamento());
			itensVendaService.create(vendaDTO);
			objDTO.setId(id);
			Agendamento oldObj = findById(id);
			Cliente cliente = oldObj.getCliente();
			oldObj = new Agendamento();
			BeanUtils.copyProperties(objDTO, oldObj);	
			oldObj.setCliente(cliente);
			return repository.save(oldObj);
			
		}else {
			objDTO.setId(id);
			Agendamento oldObj = findById(id);
			Cliente cliente = oldObj.getCliente();
			oldObj = new Agendamento();
			BeanUtils.copyProperties(objDTO, oldObj);	
			oldObj.setCliente(cliente);
			return repository.save(oldObj);
		}		
	}

	public void delete(Integer id) {
		Agendamento obj = findById(id);
		repository.deleteById(id);
	}
	
}
