package com.marcelo.sidbebi.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.enums.Status;

public class AgendamentoDTO {

	private Integer id;
	private LocalDateTime dataHora;
	
	@NotNull(message = "O campo VALOR UNITÁRIO é requerido")
	private double valorUnit;
	
	private double valorTotal;
	private String end;
	
	@NotNull(message = "O campo STATUS DO AGENDAMENTO é requerido")
	private Status status;
	
	@NotNull(message = "O campo CLIENTE é requerido")
	private Cliente idCliente;
	
	@NotNull(message = "O campo ITENS DA VENDA é requerido")
	private List<ItensVenda> itens;
	
	public AgendamentoDTO() {
		super();
	}

	public AgendamentoDTO(Agendamento obj) {
		super();
		this.id = obj.getId();
		//this.dataHora = LocalDateTime().now();
		this.valorUnit = obj.getValorUnit();
		this.valorTotal = obj.getValorTotal();
		this.end = obj.getEnd();
		this.status = obj.getStatus();
		this.idCliente = obj.getIdCliente();
		this.itens = obj.getItens();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public List<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItensVenda> itens) {
		this.itens = itens;
	}
	
}
