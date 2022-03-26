package com.marcelo.sidbebi.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensAgendamento;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.enums.Pagamento;
import com.marcelo.sidbebi.domain.enums.Status;

public class AgendamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataHora = LocalDateTime.now();
	
	private double valorTotal;
	private String end;
	
	@NotNull(message = "O campo STATUS DO AGENDAMENTO é requerido")
	private Status status;
	
	@NotNull(message = "O campo CLIENTE é requerido")
	private String cliente;
	
	@NotNull(message = "O campo ITENS DA VENDA é requerido")
	private List<ItensAgendamento> itens;
	
	@NotNull(message = "O campo ITENS DA VENDA é requerido")
	private String telefone;
	
	@NotNull(message = "O campo FORMA DE PAGAMENTO é requerido")
	private Pagamento pagamento;
	
	public AgendamentoDTO() {
		super();
	}

	public AgendamentoDTO(Agendamento obj) {
		super();
		this.id = obj.getId();
		//this.dataHora = LocalDateTime().now();
		this.valorTotal = obj.getValorTotal();
		this.end = obj.getEnd();
		this.status = obj.getStatus();
		this.cliente = obj.getCliente();
		this.itens = obj.getItens();
		this.telefone = obj.getTelefone();
		this.pagamento = obj.getPagamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/**
	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	**/

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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<ItensAgendamento> getItens() {
		return itens;
	}

	public void setItens(List<ItensAgendamento> itens) {
		this.itens = itens;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AgendamentoDTO other = (AgendamentoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
