package com.marcelo.sidbebi.domain.dtos;

import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.Produto;

public class ItensProdutoDTO {
	
	private Integer id;
	
	private Produto produto;
	
	private String codBarra;
	
	public ItensProdutoDTO() {
		super();
	}

	public ItensProdutoDTO(ItensProduto obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.codBarra = obj.getCodBarra();
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

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	
}
