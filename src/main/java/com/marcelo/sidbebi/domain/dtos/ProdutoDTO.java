package com.marcelo.sidbebi.domain.dtos;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.enums.Tipo;

public class ProdutoDTO {

private Integer id;
	
	private Tipo tipo;
	private String nome;
	private Integer quantidade;
	private double valorUnit;
	private double valorTotal;
	private Integer fornecedor;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
		this.valorUnit = obj.getValorUnit();
		this.valorTotal = obj.getValorTotal();
		this.fornecedor = obj.getFornecedor().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Integer getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Integer fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
