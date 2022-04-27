package com.marcelo.sidbebi.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.marcelo.sidbebi.domain.Usuario;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	
	@NotNull(message = "O campo EMAIL é requerido")
	protected String email;
	
	@NotNull(message = "O campo SENHA é requerido")
	protected String senha;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
