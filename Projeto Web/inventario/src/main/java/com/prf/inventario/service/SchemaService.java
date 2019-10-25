package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Schema;
import com.prf.inventario.repository.SchemaRepository;

@Service
public class SchemaService {
	
	@Autowired
	private SchemaRepository ar;

	public Iterable<Schema> listarSchema() {
		return ar.findAll();
	}
	
	public Optional<Schema> buscarSchema(int id) {
		return ar.findById(id);
	}
	
	public Schema salvarSchema(Schema Schema) {
		return ar.save(Schema);
	}
	
	public void deletarSchema (int id) {
		ar.deleteById(id);
	}
	
}