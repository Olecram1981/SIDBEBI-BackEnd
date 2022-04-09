package com.marcelo.sidbebi.domain.dtos;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.Relatorio;
import com.marcelo.sidbebi.domain.enums.Tipo;

public class RelatorioDTO {
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicial;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;
	
    private String item;
    private Tipo tipo;
    private Integer qtdTotal;
    private double valorTotal;
    
	public RelatorioDTO() {
		super();
	}

	public RelatorioDTO(Relatorio obj) {
		super();
		this.dataInicial = obj.getDataInicial();
		this.dataFinal = obj.getDataFinal();
		this.item = obj.getItem();
		this.tipo = obj.getTipo();
		this.qtdTotal = obj.getQtdTotal();
		this.valorTotal = obj.getValorTotal();
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(Integer qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
