package com.marcelo.sidbebi.domain.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.marcelo.sidbebi.domain.SaidaEstoque;

public class SaidaEstoqueDTO {
	
	private Integer id;
	
	@NotNull(message = "O PRODUTO é requerido")
    private String produto;
	
	@NotNull(message = "A QUANTIDADE é requerida")
    private Integer qtd;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora = LocalDateTime.now();
	
    private String justificativa;
    
	public SaidaEstoqueDTO() {
		super();
	}

	public SaidaEstoqueDTO(SaidaEstoque obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.qtd = obj.getQtd();
		this.justificativa = obj.getJustificativa();
		this.dataHora = obj.getDataHora();
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

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	
}
