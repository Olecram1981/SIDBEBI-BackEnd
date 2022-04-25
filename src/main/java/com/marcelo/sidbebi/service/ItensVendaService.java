package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.Relatorio;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.domain.dtos.RelatorioDTO;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.repositories.ItensProdutoRepository;
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
	private ItensProdutoRepository itensProdutoRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public ItensVenda findById(Integer id) {
		Optional<ItensVenda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public Relatorio findByItem(RelatorioDTO objDTO) {
		if(objDTO.getDataInicial() == null && objDTO.getItem() != "") {
			//busca todas as vendas do item solicitado na pequisa
			List<ItensVenda> obj = repository.findByItem(objDTO.getItem());
			objDTO.setQtdTotal(0);
			objDTO.setValorTotal(0);
			for(ItensVenda itens : obj) {
				objDTO.setValorTotal(objDTO.getValorTotal() + itens.getSubTotal());
				objDTO.setTipo(produtoRepository.findByNome(itens.getItem()).get().getTipo());
			}
		}
		else {
			if(objDTO.getDataInicial() != null && objDTO.getItem() == null) {
				//busca qualquer item vendido no intervalo de data solicitado na pesquisa
				List<Venda> vendas = vendaRepository.findByIntervalo(objDTO.getDataInicial(), objDTO.getDataFinal());
				objDTO.setQtdTotal(0);
				objDTO.setValorTotal(0);
				for(Venda venda : vendas) {
					objDTO.setValorTotal(objDTO.getValorTotal() + venda.getValorTotal());
				}
			
			}
			else {
				if(objDTO.getDataInicial() != null && objDTO.getItem() != "") {
					//busca o item solicitado dentro do intervalo de datas indicado
					//para isto eu busco uma lista de vendas do intervalo de datas requerido
					List<Venda> vendas = vendaRepository.findByIntervalo(objDTO.getDataInicial(), objDTO.getDataFinal());
					//itero esta lista de vendas buscada, procurando pelo produto solicitado	
					objDTO.setQtdTotal(0);
					objDTO.setValorTotal(0);
					for(Venda venda : vendas) {
						List<ItensVenda> itens = venda.getItens();
						for(ItensVenda item : itens) {
							if(objDTO.getItem().equals(item.getItem())) {
								objDTO.setValorTotal(objDTO.getValorTotal() + item.getSubTotal());
								objDTO.setTipo(produtoRepository.findByNome(item.getItem()).get().getTipo());
							}
						}
					}
				}
			}
		}
		Relatorio relatorio = new Relatorio();
		BeanUtils.copyProperties(objDTO, relatorio);
		return relatorio;
	}
	
	public List<ItensVenda> create(VendaDTO vendaDTO) {
		vendaDTO.setQtdItens(0);
		for(int x = 0; x < vendaDTO.getItensVenda().length; x++){
			ItensVenda itensVenda = new ItensVenda();
			Optional<ItensProduto> itensProduto = itensProdutoRepository.findByCodBarra(vendaDTO.getItensVenda()[x]);
			itensVenda.setCodBarra(itensProduto.get().getCodBarra());
			itensVenda.setItem(itensProduto.get().getNomeProduto());
			itensVenda.setSubTotal(itensVenda.getSubTotal() + itensProduto.get().getProduto().getValorUnit());
			itensVenda.setValorUnit(itensProduto.get().getProduto().getValorUnit());
			Optional<Produto> produto = produtoRepository.findById(itensProduto.get().getProduto().getId());
			vendaDTO.setValorTotal(vendaDTO.getValorTotal() + produto.get().getValorUnit());
			vendaDTO.setQtdItens(vendaDTO.getQtdItens() + 1);
			vendaDTO.setItens(vendaDTO.getItens());
			Venda venda = new Venda();		
			BeanUtils.copyProperties(vendaDTO, venda);
			itensVenda.setVenda(venda);
			itensProdutoRepository.deleteById(itensProduto.get().getId());
			repository.save(itensVenda);
			vendaRepository.save(venda);
		}		
		return vendaDTO.getItens();
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
