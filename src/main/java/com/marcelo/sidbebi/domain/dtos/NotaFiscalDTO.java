package com.marcelo.sidbebi.domain.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.NotaFiscal;

public class NotaFiscalDTO {
	
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora = LocalDateTime.now();
	
    private Integer numeroNF;
    private List<ItensVenda> itens = new ArrayList<>();
    private Cliente cliente;
    private Integer quantidade;
    private double valorUnit;    
    private double subtotal;
    private double imposto;
    private double juros;
    private double desconto;
    private double total;
	
	public NotaFiscalDTO() {
		super();
	}

	public NotaFiscalDTO(NotaFiscal obj) {
		super();
		this.dataHora = obj.getDataHora();
		this.numeroNF = obj.getNumeroNF();
		this.itens = obj.getItens();
		this.cliente = obj.getCliente();
		this.quantidade = obj.getQuantidade();
		this.valorUnit = obj.getValorUnit();
		this.subtotal = obj.getSubtotal();
		this.imposto = obj.getImposto();
		this.juros = obj.getJuros();
		this.desconto = obj.getDesconto();
		this.total = obj.getTotal();
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
