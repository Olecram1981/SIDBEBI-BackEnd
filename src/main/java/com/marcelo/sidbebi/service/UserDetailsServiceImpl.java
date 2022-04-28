package com.marcelo.sidbebi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marcelo.sidbebi.domain.Usuario;
import com.marcelo.sidbebi.domain.security.UserSS;
import com.marcelo.sidbebi.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findByEmail(email);
		if(user.isPresent()) {
			return new UserSS(user.get().getEmail(), user.get().getSenha(), user.get().getAuthorities());
		}
		throw new UsernameNotFoundException(email);
	}
}
