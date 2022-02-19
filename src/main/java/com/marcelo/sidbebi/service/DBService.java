package com.marcelo.sidbebi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.Estoque;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.enums.Tipo;
import com.marcelo.sidbebi.repositories.ClienteRepository;
import com.marcelo.sidbebi.repositories.FornecedorRepository;
import com.marcelo.sidbebi.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	//istancia e persiste os objetos no Banco de Dados
	public void instanciaDB() { 		
		Cliente cli1 = new Cliente(null, "Marcelo Machado", "88519090168", null, "9282 2316", "Rua Fernando de Noronha", "marcelo@mail.com");
		Cliente cli2 = new Cliente(null, "Albert Eisntein", "12345678910", null, "9865 5632", "Rua Alemanha", "einstein@mail.com");
		Cliente cli3 = new Cliente(null, "Carl Sagan", "10987654321", null, "5555 8704", "Rua Cosmos", "sagan@mail.com");
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));	
			
		Fornecedor f1 = new Fornecedor(null, "Ambev", "768675/0001", null, "Rua das Acácias", "3613 6743", "ambev@mail.com");
		Fornecedor f2 = new Fornecedor(null, "Coca Cola", "7565643/0001", null, "Av. Mario Andreaza", "3682 6545", "coke@mail.com");
		Fornecedor f3 = new Fornecedor(null, "ElmaChips", "9898765/0001",null, "Rua Trinta e dois", "6785 7898", "elmachips@mail.com");
		fornecedorRepository.saveAll(Arrays.asList(f1, f2, f3));
		
		List<Fornecedor> listaFornece = new ArrayList<>();
		listaFornece.add(f1);
		listaFornece.add(f2);
		listaFornece.add(f3);		
		
		Produto prod1 = new Produto(null, Tipo.ALCOOLICA, "Cerveja", 150, 3.50, 450.00, f1);
		Produto prod2 = new Produto(null, Tipo.NAOALCOOLICA, "Coca Cola", 150, 3.50, 450.00, f2);
		Produto prod3 = new Produto(null, Tipo.COMIDA, "Salgado", 150, 3.50, 450.00, f3);
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos.add(prod1);
		listaProdutos.add(prod2);
		listaProdutos.add(prod3);
		
		Estoque estoque = new Estoque(null, listaProdutos, 10, 0, 0, listaFornece);
		
	}
	
}
