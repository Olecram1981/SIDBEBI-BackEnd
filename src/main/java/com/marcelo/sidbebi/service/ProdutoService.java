package com.marcelo.sidbebi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcelo.sidbebi.domain.Fornecedor;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.dtos.ProdutoDTO;
import com.marcelo.sidbebi.repositories.ProdutoRepository;
import com.marcelo.sidbebi.service.exceptions.ObjectnotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private FornecedorService service;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado. Id: "+id));
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto create(ProdutoDTO objDTO) {	
		Fornecedor fornecedor = service.findById(objDTO.getFornecedor());
		Produto produto = new Produto();
		objDTO.setId(null);
		
		produto.setFornecedor(fornecedor);
		produto.setId(objDTO.getId());
		produto.setNome(objDTO.getNome());
		produto.setQuantidade(objDTO.getQuantidade());
		produto.setTipo(objDTO.getTipo());
		produto.setValorTotal(objDTO.getValorTotal());
		produto.setValorUnit(objDTO.getValorUnit());
		
		return repository.save(produto);
	}
	
}
