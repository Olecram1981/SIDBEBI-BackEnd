package com.marcelo.sidbebi.resourcies;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.sidbebi.domain.Usuario;
import com.marcelo.sidbebi.domain.dtos.UsuarioDTO;
import com.marcelo.sidbebi.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO objDTO){
		Usuario newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
