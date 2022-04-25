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
	
	@Autowired
	private ItensAgendamentoService itensAgendamentoService;
	
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
		Optional<Cliente> cliente = clienteRepository.findByNome(objDTO.getNomeCliente());
		objDTO.setCliente(cliente.get());
		BeanUtils.copyProperties(objDTO, newObj);
		Agendamento agendamento = repository.save(newObj);
		BeanUtils.copyProperties(agendamento, objDTO);
		itensAgendamentoService.create(objDTO);
		return agendamento;
	}	

	public Agendamento update(Integer id, AgendamentoDTO objDTO) {		
		if(objDTO.getStatus() == Status.ENTREGUE) {
			Optional<Cliente> cliente = clienteRepository.findByNome(objDTO.getNomeCliente());
			Venda venda = new Venda();
			venda.setCliente(cliente.get());
			venda.setPagamento(objDTO.getPagamento());
			venda.setItensVenda(objDTO.getItensAgendamento());
			VendaDTO vendaDTO = new VendaDTO();
			BeanUtils.copyProperties(venda, vendaDTO);
			venda =	vendaService.create(vendaDTO);
		}
		objDTO.setId(id);
		Agendamento oldObj = findById(id);
		oldObj = new Agendamento();
		BeanUtils.copyProperties(objDTO, oldObj);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Agendamento obj = findById(id);
		repository.deleteById(id);
	}
	
}
