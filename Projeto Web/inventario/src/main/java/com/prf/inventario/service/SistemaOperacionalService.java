package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.SistemaOperacional;
import com.prf.inventario.repository.SistemaOperacionalRepository;

@Service
public class SistemaOperacionalService {

	@Autowired
	private SistemaOperacionalRepository sistemaOperacionalRepository;
	
	public Iterable<SistemaOperacional> listarSistemasOperacionais() {
		return sistemaOperacionalRepository.findAll();
	}
	
	public Optional<SistemaOperacional> buscarSo(int id) {
		return sistemaOperacionalRepository.findById(id);
	}
	
	public SistemaOperacional salvarSo(SistemaOperacional so) {
		return sistemaOperacionalRepository.save(so);
	}
	
	public void deletarSo (int id) {
		sistemaOperacionalRepository.deleteById(id);
	}
}
