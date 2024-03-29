package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.LoginUsuario;
import com.prf.inventario.model.Permissao;
import com.prf.inventario.repository.LoginUsuarioRepository;
import com.prf.inventario.repository.PermissaoLoginUsuarioRepository;

@Service
public class LoginUsuarioService implements UserDetailsService {

	@Autowired
	private LoginUsuarioRepository loginUsuarioRepository;
	
	@Autowired
	private PermissaoLoginUsuarioRepository PLR;

	public Iterable<LoginUsuario> listarLoginUsuarios() {
		return loginUsuarioRepository.findAll();
	}

	public Optional<LoginUsuario> buscarLoginUsuario(String nomeLoginUsuario) {
		return loginUsuarioRepository.findById(nomeLoginUsuario);
	}

	public LoginUsuario salvarLoginUsuario(LoginUsuario loginUsuario) {
		return loginUsuarioRepository.save(loginUsuario);
	}

	public void deletarLoginUsuario(String nomeLoginUsuario) {
		loginUsuarioRepository.deleteById(nomeLoginUsuario);
	}
	
	public Iterable<Permissao> listarPermissao() {
		return PLR.findAll();
	}
	
	public Permissao salvarPermissao(Permissao permissao) {
		return PLR.save(permissao);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
