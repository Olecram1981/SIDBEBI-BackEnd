package com.marcelo.sidbebi.domain.dtos;

import java.sql.Date;

import com.marcelo.sidbebi.domain.Relatorio;
import com.marcelo.sidbebi.domain.enums.Tipo;

public class RelatorioDTO {
	
	private Date dataInicial;
    private Date dataFinal;
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

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
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
