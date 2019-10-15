package com.prf.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.inventario.model.Sgbd;
import com.prf.inventario.repository.SgbdRepository;

@Service
public class SgbdService {

	@Autowired
	private SgbdRepository sgbdRepository;
	
	public Iterable<Sgbd> listarSgbds () {
		return sgbdRepository.findAll();
	}
}
