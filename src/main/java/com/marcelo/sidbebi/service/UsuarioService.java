package com.marcelo.sidbebi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.Usuario;
import com.marcelo.sidbebi.domain.dtos.ClienteDTO;
import com.marcelo.sidbebi.domain.dtos.UsuarioDTO;
import com.marcelo.sidbebi.repositories.UsuarioRepository;
import com.marcelo.sidbebi.service.exceptions.DataIntegrityViolationException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario create(UsuarioDTO objDTO) {
		objDTO.setId(null);
		validaPorEmail(objDTO);
		Usuario newObj = new Usuario();
		BeanUtils.copyProperties(objDTO, newObj);
		return repository.save(newObj);
	}	
	
	public Usuario update(UsuarioDTO objDTO) {
		Usuario usuario = new Usuario();		
		BeanUtils.copyProperties(objDTO, usuario);
		return repository.save(usuario);
	}
	
	private void validaPorEmail(UsuarioDTO objDTO) {		
		Optional<Usuario> obj = repository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado.");
		}
	}

}
