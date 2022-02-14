package com.marcelo.sidbebi.resourcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.dtos.FornecedorDTO;
import com.marcelo.sidbebi.service.FornecedorService;

@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service;
	
	@GetMapping(value = "/{id}") //variável de path
	public ResponseEntity<FornecedorDTO> findById(@PathVariable Integer id){
		Fornecedor obj = service.findById(id);
		return ResponseEntity.ok().body(new FornecedorDTO(obj));
	}

}
