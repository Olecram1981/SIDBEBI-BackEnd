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

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.SaidaEstoque;
import com.marcelo.sidbebi.domain.dtos.ClienteDTO;
import com.marcelo.sidbebi.domain.dtos.EntradaEstoqueDTO;
import com.marcelo.sidbebi.domain.dtos.ProdutoDTO;
import com.marcelo.sidbebi.domain.dtos.SaidaEstoqueDTO;
import com.marcelo.sidbebi.service.EntradaEstoqueService;
import com.marcelo.sidbebi.service.ProdutoService;
import com.marcelo.sidbebi.service.SaidaEstoqueService;

@RestController
@RequestMapping(value="/saidas")
public class SaidaEstoqueResource {
	
	@Autowired
	private SaidaEstoqueService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaidaEstoqueDTO> findById(@PathVariable Integer id){
		SaidaEstoque obj = service.findById(id);
		return ResponseEntity.ok().body(new SaidaEstoqueDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<SaidaEstoqueDTO>> findAll(){
		List<SaidaEstoque> list = service.findAll();
		List<SaidaEstoqueDTO> listDTO = list.stream().map(obj -> new SaidaEstoqueDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<SaidaEstoqueDTO> create(@Valid @RequestBody SaidaEstoqueDTO objDTO){
		SaidaEstoque newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SaidaEstoqueDTO> atualizaEstoqueSaida(@PathVariable Integer id, @Valid @RequestBody SaidaEstoqueDTO objDTO) {
		SaidaEstoque obj = service.atualizaEstoqueSaida(id, objDTO);
		return ResponseEntity.ok().body(new SaidaEstoqueDTO(obj));
	}
	
}
