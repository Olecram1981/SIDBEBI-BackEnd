package com.marcelo.sidbebi.domain.dtos;

import com.marcelo.sidbebi.domain.Estoque;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.Produto;

public class EstoqueDTO {
	
private Integer id;
	
	private Produto produto;
	private Integer quantidade;
	private double valorUnit;
	private double valorTotal;
	private Fornecedor fornecedor;
	public EstoqueDTO() {
		super();
	}

	public EstoqueDTO(Estoque obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.quantidade = obj.getQuantidade();
		this.valorUnit = obj.getValorUnit();
		this.valorTotal = obj.getValorTotal();
		this.fornecedor = obj.getFornecedor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedores(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
