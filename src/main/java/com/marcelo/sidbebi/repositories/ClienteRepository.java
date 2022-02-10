package com.marcelo.sidbebi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.sidbebi.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
