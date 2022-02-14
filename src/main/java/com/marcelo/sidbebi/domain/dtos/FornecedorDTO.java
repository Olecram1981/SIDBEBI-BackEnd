package com.marcelo.sidbebi.domain.dtos;

import com.marcelo.sidbebi.domain.Fornecedor;

public class FornecedorDTO {

	private Integer id;	
	private String nome;
	private String cpfCnpj;
	private String end;
	private String telefone;
	private String email;
	
	public FornecedorDTO() {
		super();
	}

	public FornecedorDTO(Fornecedor obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpfCnpj = obj.getCpfCnpj();
		this.end = obj.getEnd();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
