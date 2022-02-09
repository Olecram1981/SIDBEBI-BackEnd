package com.marcelo.sidbebi.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.marcelo.sidbebi.domain.enums.Tipo;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;
	
	private Tipo tipo;
	private String nomeString;
	private Integer quantidadeInteger;
	private Integer quantidadeTotalInteger;
	private double valorUnit;
	private double valorTotal;
	
	@OneToOne
	@JoinColumn
	private Fornecedor fornecedor;

	public Produto() {
		super();
	}

	public Produto(Integer idInteger, Tipo tipo, String nomeString, Integer quantidadeInteger, Integer quantidadeTotalInteger, double valorUnit,
			double valorTotal, Fornecedor fornecedor) {
		super();
		this.idInteger = idInteger;
		this.tipo = tipo;
		this.nomeString = nomeString;
		this.quantidadeInteger = quantidadeInteger;
		this.valorUnit = valorUnit;
		this.valorTotal = valorTotal;
		this.fornecedor = fornecedor;
		this.quantidadeTotalInteger = quantidadeTotalInteger;
	}

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public Integer getQuantidadeInteger() {
		return quantidadeInteger;
	}

	public void setQuantidadeInteger(Integer quantidadeInteger) {
		this.quantidadeInteger = quantidadeInteger;
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

	public Integer getQuantidadeTotalInteger() {
		return quantidadeTotalInteger;
	}

	public void setQuantidadeTotalInteger(Integer quantidadeTotalInteger) {
		this.quantidadeTotalInteger = quantidadeTotalInteger;
	}	
	
}
