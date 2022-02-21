package com.marcelo.sidbebi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Estoque {
	
	@Id
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "produto_id")	
	private Produto produto;
	
	private Integer quantidade;
	private double valorUnit;
	private double valorTotal;
	
	@OneToOne(mappedBy = "estoque")
	private Fornecedor fornecedor;

	public Estoque() {
		super();
	}

	public Estoque(Integer id, Produto produtos, Integer quantidade, double valorUnit, double valorTotal,
			Fornecedor fornecedores) {
		super();
		this.id = id;
		this.produto = produtos;
		this.quantidade = quantidade;
		this.valorUnit = valorUnit;
		this.valorTotal = valorTotal;
		this.fornecedor = fornecedores;
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

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
