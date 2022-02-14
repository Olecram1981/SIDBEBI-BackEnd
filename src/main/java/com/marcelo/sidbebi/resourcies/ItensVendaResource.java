package com.marcelo.sidbebi.resourcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelo.sidbebi.domain.ItensVenda;
import com.marcelo.sidbebi.domain.dtos.ItensVendaDTO;
import com.marcelo.sidbebi.service.ItensVendaService;

@RestController
@RequestMapping(value="/itensvendas")
public class ItensVendaResource {
	
	@Autowired
	private ItensVendaService service;
	
	@GetMapping(value = "/{id}") //variável de path
	public ResponseEntity<ItensVendaDTO> findById(@PathVariable Integer id){
		ItensVenda obj = service.findById(id);
		return ResponseEntity.ok().body(new ItensVendaDTO(obj));
	}

}
