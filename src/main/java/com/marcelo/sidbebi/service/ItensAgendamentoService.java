package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.ItensAgendamento;
import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.dtos.AgendamentoDTO;
import com.marcelo.sidbebi.domain.dtos.ItensAgendamentoDTO;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.repositories.AgendamentoRepository;
import com.marcelo.sidbebi.repositories.ItensAgendamentoRepository;
import com.marcelo.sidbebi.repositories.ItensProdutoRepository;
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
	
	@Autowired
	private ItensProdutoRepository itensProdutoRepository;
	
	public ItensAgendamento findById(Integer id) {
		Optional<ItensAgendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public void create(AgendamentoDTO agendamentoDTO) {
		ItensAgendamento itensAgendamento = new ItensAgendamento();
		for(int x = 0; x < agendamentoDTO.getItensAgendamento().length; x++){			
			Optional<ItensProduto> itensProduto = itensProdutoRepository.findByCodBarra(agendamentoDTO.getItensAgendamento()[x]);
			itensAgendamento.setCodBarra(itensProduto.get().getCodBarra());
			itensAgendamento.setItem(itensProduto.get().getNomeProduto());
			itensAgendamento.setSubTotal(itensAgendamento.getSubTotal() + itensProduto.get().getProduto().getValorUnit());
			itensAgendamento.setValorUnit(itensProduto.get().getProduto().getValorUnit());
			itensAgendamento.getAgendamento().setId(agendamentoDTO.getId());
			ItensAgendamentoDTO objDTO = new ItensAgendamentoDTO();
			itensProdutoRepository.deleteById(itensProduto.get().getId());
			BeanUtils.copyProperties(objDTO, itensAgendamento);
			repository.save(itensAgendamento);
		}		
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
