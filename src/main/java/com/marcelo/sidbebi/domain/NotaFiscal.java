package com.marcelo.sidbebi.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NotaFiscal {
	
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora = LocalDateTime.now();
    
    @Id
    private Integer numeroNF;
    
    @ElementCollection(fetch = FetchType.EAGER)
	@JoinColumn
    private List<ItensVenda> itens = new ArrayList<>();
    
    @OneToOne	
	@JoinColumn
    private Cliente cliente;
    private Integer quantidade;
    private double valorUnit;    
    private double subtotal;
    private double imposto;
    private double juros;
    private double desconto;
    private double total;
    
	public NotaFiscal() {
		super();
	}

	public NotaFiscal(LocalDateTime dataHora, Integer numeroNF, List<ItensVenda> itens, Cliente cliente,
			Integer quantidade, double valorUnit, double subtotal, double imposto, double juros, double desconto,
			double total) {
		super();
		this.dataHora = dataHora;
		this.numeroNF = numeroNF;
		this.itens = itens;
		this.cliente = cliente;
		this.quantidade = quantidade;
		this.valorUnit = valorUnit;
		this.subtotal = subtotal;
		this.imposto = imposto;
		this.juros = juros;
		this.desconto = desconto;
		this.total = total;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getNumeroNF() {
		return numeroNF;
	}

	public void setNumeroNF(Integer numeroNF) {
		this.numeroNF = numeroNF;
	}

	public List<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItensVenda> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
