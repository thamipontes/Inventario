package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Ambiente;
import com.prf.inventario.repository.AmbienteRepository;

@Service
public class AmbienteService {
	
	@Autowired
	private AmbienteRepository ar;

	public Iterable<Ambiente> listarAmbientes() {
		return ar.findAll();
	}
	
	public Optional<Ambiente> buscarAmbiente(int id) {
		return ar.findById(id);
	}
	
	public Ambiente salvarAmbiente(Ambiente ambiente) {
		return ar.save(ambiente);
	}
	
	public void deletarAmbiente (Ambiente ambiente) {
		ar.delete(ambiente);
	}
	
}
