package com.marcelo.sidbebi.domain.dtos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

import com.marcelo.sidbebi.domain.Usuario;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	
	@NotNull(message = "O campo EMAIL é requerido")
	protected String email;
	
	@NotNull(message = "O campo SENHA é requerido")
	protected String senha;
	
	protected Set<GrantedAuthority> authorities;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.authorities = obj.getAuthorities();
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

	public Set<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
