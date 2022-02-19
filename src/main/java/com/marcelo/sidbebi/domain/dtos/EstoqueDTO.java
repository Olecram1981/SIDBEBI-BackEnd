package com.marcelo.sidbebi.domain.dtos;

import java.util.List;
import com.marcelo.sidbebi.domain.Estoque;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.Produto;

public class EstoqueDTO {
	
private Integer id;
	
	private List<Produto> produtos;
	private Integer quantidade;
	private double valorUnit;
	private double valorTotal;
	private List<Fornecedor> fornecedores;
	public EstoqueDTO() {
		super();
	}

	public EstoqueDTO(Estoque obj) {
		super();
		this.id = obj.getId();
		this.produtos = obj.getProdutos();
		this.quantidade = obj.getQuantidade();
		this.valorUnit = obj.getValorUnit();
		this.valorTotal = obj.getValorTotal();
		this.fornecedores = obj.getFornecedores();
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
