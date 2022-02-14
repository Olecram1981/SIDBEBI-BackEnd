package com.marcelo.sidbebi.domain.dtos;

import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;

public class ItensVendaDTO {
	
	private Integer id;
	private Produto itemProduto;
	private Integer quantidade;
	
	public ItensVendaDTO() {
		super();
	}

	public ItensVendaDTO(ItensVenda obj) {
		super();
		this.id = obj.getId();
		this.itemProduto = obj.getItemProduto();
		this.quantidade = obj.getQuantidade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getItemProduto() {
		return itemProduto;
	}

	public void setItemProduto(Produto itemProduto) {
		this.itemProduto = itemProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
