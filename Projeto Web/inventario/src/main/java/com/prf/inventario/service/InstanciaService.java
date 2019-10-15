package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Instancia;
import com.prf.inventario.repository.InstanciaRepository;

@Service
public class InstanciaService {
	
	@Autowired
	private InstanciaRepository instanciaRepository;

	public Iterable<Instancia> listarInstancias() {
		return instanciaRepository.findAll();
	}
	
	public Optional<Instancia> buscarInstancia(int id) {
		return instanciaRepository.findById(id);
	}
	
	public Instancia salvarInstancia(Instancia instancia) {
		return instanciaRepository.save(instancia);
	}
	
	public void deletarInstancia (int id) {
		instanciaRepository.deleteById(id);
	}
}
