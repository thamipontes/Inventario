package com.prf.Chamado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.Chamado.model.TipoChamado;

@Repository
public interface TipoChamadoRepository extends CrudRepository <TipoChamado, Integer>{

}


