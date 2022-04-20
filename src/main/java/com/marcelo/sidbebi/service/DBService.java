package com.marcelo.sidbebi.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.enums.NivelEstoque;
import com.marcelo.sidbebi.domain.enums.Tipo;
import com.marcelo.sidbebi.repositories.ClienteRepository;
import com.marcelo.sidbebi.repositories.FornecedorRepository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//istancia e persiste os objetos no Banco de Dados
	public void instanciaDB() { 
		
		Cliente cli1 = new Cliente(null, "Marcelo Machado", "987654321", new Date(1981/9/7), "9282 2316", "Rua Fernando de Noronha", "marcelo@mail.com");
		Cliente cli2 = new Cliente(null, "Albert Eisntein", "12345678910", null, "9865 5632", "Rua Alemanha", "einstein@mail.com");
		Cliente cli3 = new Cliente(null, "Carl Sagan", "10987654321", null, "5555 8704", "Rua Cosmos", "sagan@mail.com");
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));	
		
		Fornecedor f1 = new Fornecedor(null, "Ambev", "768675/0001", "Rua das Acácias", "3613 6743", "ambev@mail.com");
		Fornecedor f2 = new Fornecedor(null, "Coca Cola", "7565643/0001", "Av. Mario Andreaza", "3682 6545", "coke@mail.com");
		Fornecedor f3 = new Fornecedor(null, "ElmaChips", "9898765/0001", "Rua Trinta e dois", "6785 7898", "elmachips@mail.com");
		fornecedorRepository.saveAll(Arrays.asList(f1, f2, f3));
				
		Produto prod1 = new Produto(null, Tipo.ALCOOLICA, "Cerveja", "300 ml", 50, 3.00, 150.00, NivelEstoque.NORMAL, null);
		Produto prod2 = new Produto(null, Tipo.NAOALCOOLICA, "Coca Cola", "1 L", 150, 4.50, 450.00, NivelEstoque.ALTO, null);
		Produto prod3 = new Produto(null, Tipo.COMIDA, "Salgado", "Médio", 40, 3.50, 100.00, NivelEstoque.BAIXO, null);
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
			
	}
	
}
