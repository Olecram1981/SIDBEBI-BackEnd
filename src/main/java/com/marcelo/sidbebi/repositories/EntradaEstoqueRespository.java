package com.marcelo.sidbebi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.marcelo.sidbebi.domain.EntradaEstoque;

public interface EntradaEstoqueRespository extends JpaRepository<EntradaEstoque, Integer> {
	
}
