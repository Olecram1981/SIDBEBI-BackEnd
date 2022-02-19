package com.marcelo.sidbebi.domain.dtos;

import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.enums.Tipo;

public class ProdutoDTO {

	private Integer id;
	private Tipo tipo;
	private String nome;
		
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.nome = obj.getNome();		
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

}
