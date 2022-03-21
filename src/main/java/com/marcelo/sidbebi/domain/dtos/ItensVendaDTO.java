package com.marcelo.sidbebi.domain.dtos;


import javax.validation.constraints.NotNull;

import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;

public class ItensVendaDTO {
	
	private Integer id;
	
	@NotNull(message = "O campo ITEM DO PRODUTO é requerido")
	private Produto item;
	
	@NotNull(message = "O campo QUANTIDADE é requerido")
	private Integer quantidade;
	
	public ItensVendaDTO() {
		super();
	}

	public ItensVendaDTO(ItensVenda obj) {
		super();
		this.id = obj.getId();
		//this.itens = obj.getItens();
		this.quantidade = obj.getQuantidade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getItem() {
		return item;
	}

	public void setItem(Produto item) {
		this.item = item;
	}
	
}
