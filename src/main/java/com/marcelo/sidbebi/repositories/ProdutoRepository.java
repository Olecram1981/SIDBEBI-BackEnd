package com.marcelo.sidbebi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.sidbebi.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
