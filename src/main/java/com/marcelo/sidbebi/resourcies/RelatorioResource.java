package com.marcelo.sidbebi.resourcies;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.sidbebi.domain.Relatorio;
import com.marcelo.sidbebi.domain.Venda;
import com.marcelo.sidbebi.domain.dtos.RelatorioDTO;
import com.marcelo.sidbebi.domain.dtos.VendaDTO;
import com.marcelo.sidbebi.service.ItensVendaService;
import com.marcelo.sidbebi.service.VendaService;

@RestController
@RequestMapping(value="/relatorios")
public class RelatorioResource {
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ItensVendaService itensVendaService;
	
	@GetMapping(value = "/{relatorio}") 
	public ResponseEntity<RelatorioDTO> find(@PathVariable Relatorio relatorio){
		List<Relatorio> obj = itensVendaService.findByItem(relatorio);
		return ResponseEntity.ok().body(new RelatorioDTO(relatorio));
	}
	
	/**	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll(){
		List<Venda> list = vendaService.findAll();
		List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	**/
}