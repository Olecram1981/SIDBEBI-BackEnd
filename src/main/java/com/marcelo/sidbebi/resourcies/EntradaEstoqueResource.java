package com.marcelo.sidbebi.resourcies;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.dtos.EntradaEstoqueDTO;
import com.marcelo.sidbebi.service.EntradaEstoqueService;

@RestController
@RequestMapping(value="/entradas")
public class EntradaEstoqueResource {
	
	@Autowired
	private EntradaEstoqueService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EntradaEstoqueDTO> findById(@PathVariable Integer id){
		EntradaEstoque obj = service.findById(id);
		return ResponseEntity.ok().body(new EntradaEstoqueDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<EntradaEstoqueDTO>> findAll(){
		List<EntradaEstoque> list = service.findAll();
		List<EntradaEstoqueDTO> listDTO = list.stream().map(obj -> new EntradaEstoqueDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<EntradaEstoqueDTO> create(@Valid @RequestBody EntradaEstoqueDTO objDTO){
		EntradaEstoque newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EntradaEstoqueDTO> atualizaEstoqueEntrada(@PathVariable Integer id, @Valid @RequestBody EntradaEstoqueDTO objDTO) {
		EntradaEstoque obj = service.atualizaEstoqueEntrada(id, objDTO);
		return ResponseEntity.ok().body(new EntradaEstoqueDTO(obj));
	}
	
}
