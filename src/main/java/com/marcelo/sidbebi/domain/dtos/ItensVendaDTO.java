package com.marcelo.sidbebi.domain.dtos;


import javax.validation.constraints.NotNull;

import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.Venda;

public class ItensVendaDTO {
	
	private Integer id;
	
	@NotNull(message = "O campo ITEM DO PRODUTO é requerido")
	private String item;
	
	@NotNull(message = "O campo QUANTIDADE é requerido")
	private Integer quantidade;
	
	private double valorUnit;
	
	private Venda venda;
	
	public ItensVendaDTO() {
		super();
	}

	public ItensVendaDTO(ItensVenda obj) {
		super();
		this.id = obj.getId();
		this.item = obj.getItem();
		this.quantidade = obj.getQuantidade();
		this.valorUnit = obj.getValorUnit();
		this.venda = obj.getVenda();
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
}
