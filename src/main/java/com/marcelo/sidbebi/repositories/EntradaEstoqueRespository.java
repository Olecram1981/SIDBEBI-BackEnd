package com.marcelo.sidbebi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.Produto;

public interface EntradaEstoqueRespository extends JpaRepository<EntradaEstoque, Integer> {
	
}
