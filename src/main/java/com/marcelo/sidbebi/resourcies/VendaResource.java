package com.marcelo.sidbebi.resourcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.service.VendaService;

@RestController
@RequestMapping(value="/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService service;
	
	@GetMapping(value = "/{id}") //variável de path
	public ResponseEntity<VendaDTO> findById(@PathVariable Integer id){
		Venda obj = service.findById(id);
		return ResponseEntity.ok().body(new VendaDTO(obj));
	}

}
