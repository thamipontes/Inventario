package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Sistema;
import com.prf.inventario.repository.SistemaRepository;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;
	
	public Iterable<Sistema> listarSistemas() {
		return sistemaRepository.findAll();
	}
	
	public Optional<Sistema> buscarSistema(int id) {
		return sistemaRepository.findById(id);
	}
	
	public Sistema salvarSistema(Sistema sistema) {
		return sistemaRepository.save(sistema);
	}
	
	public void deletarSistema (int id) {
		sistemaRepository.deleteById(id);
	}
}
