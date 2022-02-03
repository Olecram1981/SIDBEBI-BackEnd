package com.marcelo.sidbebi.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.marcelo.sidbebi.domain.enums.Status;

import antlr.collections.List;

public class Agendamento {
	
	private Integer idInteger;
	private LocalDate dataDate = LocalDate.now();
	private LocalDateTime hora = LocalDateTime.now();
	private String nomeString;
	private double valorUnitario;
	private double valorTotal;
	private String endString;
	private Status status;
	
	private Cliente cliente;
	private Produto produto;
	
	public Agendamento() {
		super();
	}

	public Agendamento(Integer idInteger, String nomeString, double valorUnitario, double valorTotal, String endString,
			Status status, Cliente cliente, Produto produto) {
		super();
		this.idInteger = idInteger;
		this.nomeString = nomeString;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.endString = endString;
		this.status = status;
		this.cliente = cliente;
		this.produto = produto;
	}

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public LocalDate getDataDate() {
		return dataDate;
	}

	public void setDataDate(LocalDate dataDate) {
		this.dataDate = dataDate;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getEndString() {
		return endString;
	}

	public void setEndString(String endString) {
		this.endString = endString;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInteger == null) ? 0 : idInteger.hashCode());
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
		Agendamento other = (Agendamento) obj;
		if (idInteger == null) {
			if (other.idInteger != null)
				return false;
		} else if (!idInteger.equals(other.idInteger))
			return false;
		return true;
	}
	
}
