package com.marcelo.sidbebi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NotaFiscal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora = LocalDateTime.now();
    
    @Id
    private Integer numeroNF;
    
    @OneToOne	
	@JoinColumn
    private Cliente cliente;
    
    @OneToMany (mappedBy = "venda")	
	private List<ItensVenda> itens;
    
    @ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda venda;
    
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

	public NotaFiscal(LocalDateTime dataHora, Integer numeroNF, Cliente cliente, List<ItensVenda> itens,
			Integer quantidade, double valorUnit, double subtotal, double imposto, double juros, double desconto,
			double total) {
		super();
		this.dataHora = dataHora;
		this.numeroNF = numeroNF;
		this.cliente = cliente;
		this.itens = itens;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItensVenda> itens) {
		this.itens = itens;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroNF == null) ? 0 : numeroNF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscal other = (NotaFiscal) obj;
		if (numeroNF == null) {
			if (other.numeroNF != null)
				return false;
		} else if (!numeroNF.equals(other.numeroNF))
			return false;
		return true;
	}

}
