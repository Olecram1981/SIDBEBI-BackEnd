package com.marcelo.sidbebi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Usuario;
import com.marcelo.sidbebi.domain.dtos.UsuarioDTO;
import com.marcelo.sidbebi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario update(UsuarioDTO objDTO) {
		Usuario usuario = new Usuario(1, objDTO.getEmail(), objDTO.getSenha());		
		BeanUtils.copyProperties(objDTO, usuario);
		return repository.save(usuario);
	}

}
