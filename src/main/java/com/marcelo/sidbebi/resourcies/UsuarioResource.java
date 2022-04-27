package com.marcelo.sidbebi.resourcies;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.sidbebi.domain.Usuario;
import com.marcelo.sidbebi.domain.dtos.UsuarioDTO;
import com.marcelo.sidbebi.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@PutMapping
	public ResponseEntity<UsuarioDTO> update(@Valid @RequestBody UsuarioDTO objDTO) {
		Usuario obj = service.update(objDTO);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	
}
