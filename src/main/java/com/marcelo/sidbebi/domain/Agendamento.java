package com.marcelo.sidbebi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.enums.Status;


@Entity
public class Agendamento {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDate = LocalDate.now();
	private LocalDateTime hora = LocalDateTime.now();
	
	private String nomeString;
	private double valorUnitario;
	private double valorTotal;
	private String endString;
	
	private Status status;
	
	@ManyToOne	
	@JoinColumn
	private Cliente cliente;
	
	@OneToMany(mappedBy = "idInteger")	
	private List<Produto> produto = new ArrayList<>();
	
	public Agendamento() {
		super();
	}

	public Agendamento(Integer idInteger, String nomeString, double valorUnitario,
			double valorTotal, String endString, Status status, Cliente cliente, List<Produto> produto) {
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
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