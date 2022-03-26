package com.marcelo.sidbebi.domain.dtos;


import javax.validation.constraints.NotNull;
import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.ItensAgendamento;
public class ItensAgendamentoDTO {
	
	private Integer id;
	
	@NotNull(message = "O campo ITEM DO PRODUTO é requerido")
	private String item;
	
	@NotNull(message = "O campo QUANTIDADE é requerido")
	private Integer quantidade;
	
	private double valorUnit;
	private Agendamento agendamento;
	private double subTotal;
	
	public ItensAgendamentoDTO() {
		super();
	}

	public ItensAgendamentoDTO(ItensAgendamento obj) {
		super();
		this.id = obj.getId();
		this.item = obj.getItem();
		this.quantidade = obj.getQuantidade();
		this.valorUnit = obj.getValorUnit();
		this.agendamento = obj.getAgendamento();
		this.subTotal = obj.getSubTotal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
}
