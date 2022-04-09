package com.marcelo.sidbebi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.sidbebi.domain.ItensVenda;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Integer>{
	
	List<ItensVenda> findByItem(String item);

}
