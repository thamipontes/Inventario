package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.prf.inventario.model.SistemaOperacional;
import com.prf.inventario.repository.SistemaOperacionalRepository;

public class SistemaOperacionalService {

	@Autowired
	private SistemaOperacionalRepository sistemaOperacionalRepository;
	
	public Iterable<SistemaOperacional> listarSistemasOperacionais() {
		return sistemaOperacionalRepository.findAll();
	}
	
	public Optional<SistemaOperacional> buscarAmbiente(int id) {
		return sistemaOperacionalRepository.findById(id);
	}
	
	public SistemaOperacional SalvarAmbiente(SistemaOperacional so) {
		return sistemaOperacionalRepository.save(so);
	}
	
	public void deletarAmbiente (int id) {
		sistemaOperacionalRepository.deleteById(id);
	}
}
