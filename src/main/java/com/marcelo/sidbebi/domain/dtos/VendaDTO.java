package com.marcelo.sidbebi.domain.dtos;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.enums.Pagamento;

public class VendaDTO {
	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataHora = LocalDate.now();
	
	private List<ItensVenda> itens;
	
	@NotNull(message = "O campo ITENS DA VENDA é requerido")
	private String[] itensVenda;
	
	private	Integer cliente;
	
	private Integer qtdItens;
	
	private double valorTotal;
	
	@NotNull(message = "O campo FORMA DO PAGAMENTO é requerido")
	private Pagamento pagamento;
	
	public VendaDTO() {
		super();
	}

	public VendaDTO(Venda obj) {
		super();
		this.id = obj.getId();
		this.dataHora = obj.getDataHora();
		this.itens = obj.getItens();
		this.itensVenda = obj.getItensVenda();
		this.cliente = obj.getCliente().getId();
		this.qtdItens = obj.getQtdItens();
		this.valorTotal = obj.getValorTotal();
		this.pagamento = obj.getPagamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}

	public List<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItensVenda> itens) {
		this.itens = itens;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public String[] getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(String[] itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

}
