package com.marcelo.sidbebi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.Produto;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	Optional<Cliente> findByNome(String nome);
	
	Optional<Cliente> findByCpfCnpj(String cpfCnpj);
	
	Optional<Cliente> findByEmail(String email);
	
}
