package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Usuario;
import com.prf.inventario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Iterable<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> buscarUsuario(int id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void deletarUsuario (int id) {
		usuarioRepository.deleteById(id);
	}
}
