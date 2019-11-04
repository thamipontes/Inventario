package com.prf.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Base;
import com.prf.inventario.repository.BaseRepository;

@Service
public class BaseService {
	
	@Autowired
	private BaseRepository br;

	public Iterable<Base> listarBases() {
		return br.findAll();
	}
	
	public Optional<Base> buscarBase(int id) {
		return br.findById(id);
	}
	
	public Base salvarBase(Base base) {
		return br.save(base);
	}
	
	public void deletarBase (Base base) {
		br.delete(base);
	}
	
}
