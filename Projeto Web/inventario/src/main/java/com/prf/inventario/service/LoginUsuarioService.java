package com.prf.inventario.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prf.inventario.model.LoginUsuario;
import com.prf.inventario.model.Permissoes;
import com.prf.inventario.repository.LoginUsuarioRepository;

@Service
public class LoginUsuarioService implements UserDetailsService {

	@Autowired
	private LoginUsuarioRepository loginUsuarioRepository;

	public Iterable<LoginUsuario> listarLoginUsuarios() {
		return loginUsuarioRepository.findAll();
	}

	public Optional<LoginUsuario> buscarLoginUsuario(String nomeUsuario) {
		return loginUsuarioRepository.findById(nomeUsuario);
	}

	public LoginUsuario salvarLoginUsuario(LoginUsuario loginUsuario) {
		return loginUsuarioRepository.save(loginUsuario);
	}

	public void deletarLoginUsuario(String nomeUsuario) {
		loginUsuarioRepository.deleteById(nomeUsuario);
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String nomeLoginUsuario) throws UsernameNotFoundException {

		Optional<LoginUsuario> loginUsuariOptional = loginUsuarioRepository.findById(nomeLoginUsuario);

		UserBuilder builder = null;
		if (loginUsuariOptional != null) {
			LoginUsuario loginUsuario = loginUsuariOptional.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(nomeLoginUsuario);
			builder.disabled(!loginUsuario.isAtivo());
			builder.password(loginUsuario.getSenhaLogin());
			ArrayList <String> listaPermissoes = new ArrayList<>(); 
			for (Permissoes p : loginUsuario.getPermissoes()) {
				listaPermissoes.add(p.getNomePermissao());
			}

			builder.authorities(listaPermissoes.toArray(new String[0]));
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}
}
