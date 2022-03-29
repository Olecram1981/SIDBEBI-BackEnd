package com.marcelo.sidbebi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SaidaEstoque implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
    private String produto;
    private Integer qtd;
    //private LocalDateTime dataHora = LocalDateTime.now();
    private String justificativa;
    
	public SaidaEstoque() {
		super();
	}

	public SaidaEstoque(Integer id, String produto, Integer qtd, String justificativa) {
		super();
		this.id = id;
		this.produto = produto;
		this.qtd = qtd;
		this.justificativa = justificativa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
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
		SaidaEstoque other = (SaidaEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}
