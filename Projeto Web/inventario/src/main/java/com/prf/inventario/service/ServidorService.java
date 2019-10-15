package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.DiscosServidor;
import com.prf.inventario.model.Servidor;
import com.prf.inventario.repository.DiscosServidorRepository;
import com.prf.inventario.repository.ServidorRepository;

@Service
public class ServidorService {

	@Autowired
	private ServidorRepository servidorRepository;
	
	@Autowired
	private DiscosServidorRepository discosRepository;
	
	public Iterable<Servidor> listarServidores() {
		return servidorRepository.findAll();
	}
	
	public Optional<Servidor> buscarServidor(int id) {
		return servidorRepository.findById(id);
	}
	
	public Servidor salvarServidor(Servidor srv) {
		return servidorRepository.save(srv);
	}
	
	public void deletarServidor (int id) {
		servidorRepository.deleteById(id);
	}
	
	public Iterable<DiscosServidor> listarDiscos() {
		return discosRepository.findAll();
	}
	
	public DiscosServidor salvarDisco(DiscosServidor disco) {
		return discosRepository.save(disco);
	}
}
