package com.marcelo.sidbebi.domain.dtos;

import javax.validation.constraints.NotNull;

import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.ItensProduto;
import com.marcelo.sidbebi.domain.Produto;

public class ItensProdutoDTO {
	
	private Integer id;
	
	private Produto produto;
	
	private Fornecedor fornecedor;
	
	@NotNull(message = "O campo CÓDIGO DE BARRAS é requerido")
	private String codBarra;
	
	private String nomeProduto;
	private String nomeFornecedor;
	
	public ItensProdutoDTO() {
		super();
	}

	public ItensProdutoDTO(ItensProduto obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.fornecedor = obj.getFornecedor();
		this.codBarra = obj.getCodBarra();
		this.nomeProduto = obj.getProduto().getNome();
		this.nomeFornecedor = obj.getFornecedor().getNome();
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
}
