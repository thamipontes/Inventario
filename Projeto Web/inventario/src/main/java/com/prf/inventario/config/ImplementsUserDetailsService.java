package com.prf.inventario.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prf.inventario.model.LoginUsuario;
import com.prf.inventario.repository.LoginUsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private LoginUsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional <LoginUsuario> loginUsuarioOpt = ur.findById(login);
		
		if(loginUsuarioOpt == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}		
		LoginUsuario loginUsuario = loginUsuarioOpt.get();
		return new User(loginUsuario.getUsername(), loginUsuario.getPassword(), true, true, true, true, loginUsuario.getAuthorities());

	}
}

//new User(loginUsuario.getUsername(), loginUsuario.getPassword(), true, true, true, true, loginUsuario.getAuthorities());


