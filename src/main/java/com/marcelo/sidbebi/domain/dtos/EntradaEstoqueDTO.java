package com.marcelo.sidbebi.domain.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.Produto;

public class EntradaEstoqueDTO {
	
	private Integer id;
	
	@NotNull(message = "O PRODUTO é requerido")
    private String produto;
	
    private String fornecedor;
    
    @NotNull(message = "A QUANTIDADE é requerida")
    private Integer qtd;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora = LocalDateTime.now();
    
    private double valor;
    
	public EntradaEstoqueDTO() {
		super();
	}

	public EntradaEstoqueDTO(EntradaEstoque obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.fornecedor = obj.getFornecedor();
		this.qtd = obj.getQtd();
		this.valor = obj.getValor();
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

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
    
}
