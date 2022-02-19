package com.marcelo.sidbebi.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Estoque {
	
	@Id
	private Integer id;
	
	@OneToMany
	@JoinColumn(name = "estoque")	
	private List<Produto> produtos;
	
	private Integer quantidade;
	private double valorUnit;
	private double valorTotal;
	
	@OneToMany(mappedBy = "estoque")
	private List<Fornecedor> fornecedores;

	public Estoque() {
		super();
	}

	public Estoque(Integer id, List<Produto> produtos, Integer quantidade, double valorUnit, double valorTotal,
			List<Fornecedor> fornecedores) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.quantidade = quantidade;
		this.valorUnit = valorUnit;
		this.valorTotal = valorTotal;
		this.fornecedores = fornecedores;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
}
