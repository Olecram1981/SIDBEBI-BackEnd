package com.marcelo.sidbebi.resourcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelo.sidbebi.domain.Agendamento;
import com.marcelo.sidbebi.domain.dtos.AgendamentoDTO;
import com.marcelo.sidbebi.service.AgendamentoService;

@RestController
@RequestMapping(value="/agendamentos")
public class AgendamentoResource {
	
	@Autowired
	private AgendamentoService service;
	
	@GetMapping(value = "/{id}") //variável de path
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable Integer id){
		Agendamento obj = service.findById(id);
		return ResponseEntity.ok().body(new AgendamentoDTO(obj));
	}

}
