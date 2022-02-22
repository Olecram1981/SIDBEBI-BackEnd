package com.marcelo.sidbebi.domain.dtos;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.sidbebi.domain.Cliente;

public class ClienteDTO {
	
	private Integer id;
	
	@NotNull(message = "O campo NOME é requerido")
	private String nome;
	
	@NotNull(message = "O campo CPF/CNPJ é requerido")
	private String cpfCnpj;
	
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private Date dataNasc;
	private String telefone;
	private String endereco;
	
	@NotNull(message = "O campo E-mail é requerido")
	private String email;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();	
		this.nome = obj.getNome();
		this.cpfCnpj = obj.getCpfCnpj();
		this.dataNasc = obj.getDataNasc();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
