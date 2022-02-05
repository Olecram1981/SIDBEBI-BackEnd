package com.marcelo.sidbebi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;
	
	private String nomeString;
	
	@Column(unique = true)
	private String cpfCnpjString;
	private String endString;
	private String telefoneString;
	
	@Column(unique = true)
	private String emailString;

	public Fornecedor() {
		super();
	}

	public Fornecedor(Integer idInteger, String nomeString, String cpfCnpjString, String endString,
			String telefoneString, String emailString) {
		super();
		this.idInteger = idInteger;
		this.nomeString = nomeString;
		this.cpfCnpjString = cpfCnpjString;
		this.endString = endString;
		this.telefoneString = telefoneString;
		this.emailString = emailString;
	}

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public String getCpfCnpjString() {
		return cpfCnpjString;
	}

	public void setCpfCnpjString(String cpfCnpjString) {
		this.cpfCnpjString = cpfCnpjString;
	}

	public String getEndString() {
		return endString;
	}

	public void setEndString(String endString) {
		this.endString = endString;
	}

	public String getTelefoneString() {
		return telefoneString;
	}

	public void setTelefoneString(String telefoneString) {
		this.telefoneString = telefoneString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	
}
