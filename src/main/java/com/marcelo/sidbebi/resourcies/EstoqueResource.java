package com.marcelo.sidbebi.resourcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelo.sidbebi.domain.Estoque;
import com.marcelo.sidbebi.domain.dtos.EstoqueDTO;
import com.marcelo.sidbebi.service.EstoqueService;

@RestController
@RequestMapping(value="/estoques")
public class EstoqueResource {
	
	@Autowired
	private EstoqueService service;
	
	@GetMapping(value = "/{id}") //variável de path
	public ResponseEntity<EstoqueDTO> findById(@PathVariable Integer id){
		Estoque obj = service.findById(id);
		return ResponseEntity.ok().body(new EstoqueDTO(obj));
	}
	
}
