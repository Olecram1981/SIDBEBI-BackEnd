package com.marcelo.sidbebi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.sidbebi.domain.Cliente;
import com.marcelo.sidbebi.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
