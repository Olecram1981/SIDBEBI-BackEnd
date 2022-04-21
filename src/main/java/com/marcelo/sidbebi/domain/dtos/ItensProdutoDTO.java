package com.marcelo.sidbebi.domain.dtos;

import javax.validation.constraints.NotNull;

import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.Produto;

public class ItensProdutoDTO {
	
	private Integer id;
	
	@NotNull(message = "O campo PRODUTO é requerido")
	private String produto;
	
	@NotNull(message = "O campo FORNECEDOR é requerido")
	private String fornecedor;
	
	@NotNull(message = "O campo CÓDIGO DE BARRAS é requerido")
	private String codBarra;
	
	public ItensProdutoDTO() {
		super();
	}

	public ItensProdutoDTO(ItensProduto obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.fornecedor = obj.getFornecedor();
		this.codBarra = obj.getCodBarra();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
