package com.marcelo.sidbebi.domain;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcelo.sidbebi.domain.enums.Pagamento;
import com.marcelo.sidbebi.domain.enums.Status;


@Entity
public class Agendamento {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToMany (mappedBy = "agendamento")	
	private List<ItensAgendamento> itens;
	
	private double valorTotal;
	private String end;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataHora = LocalDateTime.now();
	
	private Status status;
	private String nomeCliente;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private String telefone;
	private Pagamento pagamento;
	
	public Agendamento() {
		super();
	}

	public Agendamento(Integer id, double valorTotal, String end, Status status, String nomeCliente, Cliente cliente,
			List<ItensAgendamento> itens, String telefone, Pagamento pagamento, LocalDateTime dataHora) {
		super();
		
		this.id = id;
		this.valorTotal = valorTotal;
		this.end = end;
		this.status = status;
		this.cliente = cliente;
		this.nomeCliente = nomeCliente;
		this.cliente = cliente;
		this.itens = itens;
		this.telefone = telefone;
		this.pagamento = pagamento;
		this.dataHora = dataHora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}