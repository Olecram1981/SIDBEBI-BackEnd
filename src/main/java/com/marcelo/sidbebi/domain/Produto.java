package com.marcelo.sidbebi.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.marcelo.sidbebi.domain.dtos.ProdutoDTO;
import com.marcelo.sidbebi.domain.enums.Tipo;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Tipo tipo;
	private String nome;	
	
	@OneToOne(mappedBy = "produto")
	private Estoque estoque;
	
	public Produto() {
		super();
	}
	
	public Produto(ProdutoDTO obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.nome = obj.getNome();		
	}
	
	public Produto(Integer id, Tipo tipo, String nome, Integer quantidade, double valorUnit, double valorTotal,
			Fornecedor fornecedor) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
