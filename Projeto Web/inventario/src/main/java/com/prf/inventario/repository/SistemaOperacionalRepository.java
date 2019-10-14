


package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.SistemaOperacional;

@Repository
public interface SistemaOperacionalRepository extends CrudRepository <SistemaOperacional, Integer>{

}
