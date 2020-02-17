package com.prf.Chamado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prf.Chamado.model.TipoChamado;
import com.prf.Chamado.repository.TipoChamadoRepository;

@Service
public class TipoChamadoService {
	
	@Autowired
	private TipoChamadoRepository tcr;

	public Iterable<TipoChamado> listarTipoChamado() {
		return tcr.findAll();
	}
	
	public Optional<TipoChamado> buscarTipoChamado(int id) {
		return tcr.findById(id);
	}
	
	public TipoChamado salvarTipoChamado(TipoChamado tipoChamado) {
		return tcr.save(tipoChamado);
	}
	
	public void deletarTipoChamado (TipoChamado tipoChamado) {
		tcr.delete(tipoChamado);
	}
	
}

