package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.SchemaUsuario;
import com.prf.inventario.repository.SchemaUsuarioRepository;

@Service
public class SchemaUsuarioService {
	
	@Autowired
	private SchemaUsuarioRepository ar;

	public Iterable<SchemaUsuario> listarSchemaUsuario() {
		return ar.findAll();
	}
	
	public Optional<SchemaUsuario> buscarSchemaUsuario(int id) {
		return ar.findById(id);
	}
	
	public SchemaUsuario salvarSchemaUsuario(SchemaUsuario SchemaUsuario) {
		return ar.save(SchemaUsuario);
	}
	
	public void deletarSchemaUsuario (int id) {
		ar.deleteById(id);
	}
	
}