package com.marcelo.sidbebi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.enums.Pagamento;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDate = LocalDate.now();
	private LocalDateTime horaDateTime = LocalDateTime.now();
	
	@OneToMany
	private Set<Produto> produto;
	
	private Integer quantidadeInteger;
	private double valorUnit;
	private double total;
	private Pagamento pagamento;
	
	public Venda() {
		super();
	}

	public Venda(Integer idInteger, Set<Produto> produto, Integer quantidadeInteger, double valorUnit, double total,
			Pagamento pagamento) {
		super();
		this.idInteger = idInteger;
		this.produto = produto;
		this.quantidadeInteger = quantidadeInteger;
		this.valorUnit = valorUnit;
		this.total = total;
		this.pagamento = pagamento;
	}

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public Set<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}

	public Integer getQuantidadeInteger() {
		return quantidadeInteger;
	}

	public void setQuantidadeInteger(Integer quantidadeInteger) {
		this.quantidadeInteger = quantidadeInteger;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public void atualizarEstoque() {
		//for(this.produto :: ) {}
	}
	
}
