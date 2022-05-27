package com.marcelo.sidbebi.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.enums.Pagamento;

public class VendaDTO {
	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
	private LocalDateTime dataHora = LocalDateTime.now();
	
	private List<ItensVenda> itens;
	
	@NotNull(message = "O campo ITENS DA VENDA é requerido")
	private String[] itensVenda;
	
	private	Integer cliente;
	
	private String nomeCliente;
	
	private Integer qtdItens;
	
	private double valorTotal;
	
	@NotNull(message = "O campo FORMA DO PAGAMENTO é requerido")
	private Integer pagamento;
	
	public VendaDTO() {
		super();
	}

	public VendaDTO(Venda obj) {
		super();
		this.id = obj.getId();
		this.itens = obj.getItens();
		this.itensVenda = obj.getItensVenda();
		this.cliente = obj.getCliente().getId();
		this.nomeCliente = obj.getNomeCliente();
		this.qtdItens = obj.getQtdItens();
		this.valorTotal = obj.getValorTotal();
		this.pagamento = obj.getPagamento().getCodigoInteger();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPagamento() {
		return pagamento;
	}

	public void setPagamento(Integer pagamento) {
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
}
