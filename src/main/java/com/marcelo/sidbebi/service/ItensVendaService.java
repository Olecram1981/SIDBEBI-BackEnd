package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.Relatorio;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.ItensProdutoDTO;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.domain.dtos.RelatorioDTO;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.domain.enums.Pagamento;
import com.marcelo.sidbebi.domain.enums.Tipo;
import com.marcelo.sidbebi.repositories.ClienteRepository;
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
	private ItensProdutoService itensProdutoService;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public ItensVenda findById(Integer id) {
		Optional<ItensVenda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public List<RelatorioDTO> findByItem(RelatorioDTO objDTO) {
		List<RelatorioDTO> relatorioDTO = null;
		if(objDTO.getDataInicial() == null && objDTO.getProduto().getNome() != "") {
			//busca todas as vendas do item solicitado na pequisa
			List<ItensVenda> itens = repository.findByItem(objDTO.getProduto().getNome());
			
			for(ItensVenda item : itens) {
				objDTO.getProduto().setNome(item.getItem());
				objDTO.setQtdTotal(item.getVenda().getQtdItens());
				objDTO.setTamanho(item.getTamanho());
				objDTO.setTipo(produtoRepository.findByNome(item.getItem()).get().getTipo());
				objDTO.setValorTotal(item.getVenda().getValorTotal());
				relatorioDTO.add(objDTO);
			}
			return relatorioDTO;
		}
		else {
			if(objDTO.getDataInicial() != null && objDTO.getProduto() == null) {
				//busca qualquer item vendido no intervalo de data solicitado na pesquisa
				List<Venda> vendas = vendaRepository.findByIntervalo(objDTO.getDataInicial(), objDTO.getDataFinal());
				
				for(Venda venda : vendas) {
					objDTO.setQtdTotal(venda.getQtdItens());
					objDTO.setValorTotal(venda.getValorTotal());
					relatorioDTO.add(objDTO);
				}
				return relatorioDTO;			
			}
			else {
				if(objDTO.getDataInicial() != null && objDTO.getProduto().getNome() != "") {
					//busca o item solicitado dentro do intervalo de datas indicado
					//para isto eu busco uma lista de vendas do intervalo de datas requerido
					List<Venda> vendas = vendaRepository.findByIntervalo(objDTO.getDataInicial(), objDTO.getDataFinal());
					//itero esta lista de vendas buscada, procurando pelo produto solicitado	
					
					for(Venda venda : vendas) {
						List<ItensVenda> itens = venda.getItens();
						for(ItensVenda item : itens) {
							if(objDTO.getProduto().equals(item.getItem())) {
								objDTO.getProduto().setNome(item.getItem());
								objDTO.setQtdTotal(item.getVenda().getQtdItens());
								objDTO.setTamanho(item.getTamanho());
								objDTO.setTipo(produtoRepository.findByNome(item.getItem()).get().getTipo());
								objDTO.setValorTotal(item.getVenda().getValorTotal());
								relatorioDTO.add(objDTO);
							}
						}
					}
					return relatorioDTO;
				}				
			}
		}
		return relatorioDTO;
	}
	
	public Venda create(VendaDTO vendaDTO) {
		Venda venda = new Venda();		
		BeanUtils.copyProperties(vendaDTO, venda);
		venda.setPagamento(Pagamento.toEnum(vendaDTO.getPagamento()));
		venda = vendaRepository.save(venda);
		
		for(int x = 0; x < vendaDTO.getItensVenda().length; x++){						
			ItensVenda itensVenda = new ItensVenda();
			Optional<ItensProduto> itensProduto = itensProdutoRepository.findByCodBarra(vendaDTO.getItensVenda()[x]);
			itensVenda.setCodBarra(itensProduto.get().getCodBarra());
			itensVenda.setValorUnit(itensProduto.get().getProduto().getValorUnit());			
			itensVenda.setFornecedor(itensProduto.get().getFornecedor().getNome());
			itensVenda.setItem(itensProduto.get().getProduto().getNome());
			itensVenda.setTamanho(itensProduto.get().getProduto().getTamanho());
			itensVenda.setVenda(venda);		
			repository.save(itensVenda);
			itensProdutoRepository.deleteById(itensProduto.get().getId());
		}		
		
		return venda;
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
		ItensProdutoDTO itensProdutoDTO = new  ItensProdutoDTO();
		itensProdutoDTO.setCodBarra(obj.getCodBarra());
		itensProdutoService.create(itensProdutoDTO);
		repository.deleteById(id);
	}
	
}
