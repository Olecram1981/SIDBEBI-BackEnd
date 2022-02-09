package com.marcelo.sidbebi.domain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.enums.Pagamento;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDate = LocalDate.now();
	//private LocalDateTime horaDateTime = LocalDateTime.now();
	
	@OneToMany(mappedBy = "idInteger")
	private List<Produto> produto = new ArrayList<>();
	
	@OneToOne	
	@JoinColumn
	private	Cliente cliente;
	
	private Integer quantidadeInteger;
	private double valorUnit;
	private double total;
	private Pagamento pagamento;
	
	public Venda() {
		super();
	}

	public Venda(Integer idInteger, List<Produto> produto, Integer quantidadeInteger, double valorUnit, double total,
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
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
