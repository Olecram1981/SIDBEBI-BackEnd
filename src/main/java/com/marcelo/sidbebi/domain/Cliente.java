package com.marcelo.sidbebi.domain;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;
	
	private String nomeString;
	
	@Column(unique = true)
	private String cpfCnpjString;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascDate;
	private String telefoneString;
	private String enderecoString;
	
	@Column(unique = true)
	private String emailString;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer idInteger, String nomeString, String cpfCnpjString, Date dataNascDate, String telefoneString,
			String enderecoString, String emailString) {
		super();
		this.idInteger = idInteger;
		this.nomeString = nomeString;
		this.cpfCnpjString = cpfCnpjString;
		this.dataNascDate = dataNascDate;
		this.telefoneString = telefoneString;
		this.enderecoString = enderecoString;
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

	public Date getDataNascDate() {
		return dataNascDate;
	}

	public void setDataNascDate(Date dataNascDate) {
		this.dataNascDate = dataNascDate;
	}

	public String getTelefoneString() {
		return telefoneString;
	}

	public void setTelefoneString(String telefoneString) {
		this.telefoneString = telefoneString;
	}

	public String getEnderecoString() {
		return enderecoString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	
	public String getEmailString() {
		return emailString;
	}

	public void setEnderecoString(String enderecoString) {
		this.enderecoString = enderecoString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpjString == null) ? 0 : cpfCnpjString.hashCode());
		result = prime * result + ((idInteger == null) ? 0 : idInteger.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpfCnpjString == null) {
			if (other.cpfCnpjString != null)
				return false;
		} else if (!cpfCnpjString.equals(other.cpfCnpjString))
			return false;
		if (idInteger == null) {
			if (other.idInteger != null)
				return false;
		} else if (!idInteger.equals(other.idInteger))
			return false;
		return true;
	}
	
	
}
