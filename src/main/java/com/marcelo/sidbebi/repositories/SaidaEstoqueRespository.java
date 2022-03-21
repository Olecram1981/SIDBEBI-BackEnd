package com.marcelo.sidbebi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.marcelo.sidbebi.domain.EntradaEstoque;
import com.marcelo.sidbebi.domain.Produto;
import com.marcelo.sidbebi.domain.SaidaEstoque;

public interface SaidaEstoqueRespository extends JpaRepository<SaidaEstoque, Integer> {
	
}
