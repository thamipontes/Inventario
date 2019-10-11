
package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Ambiente;

@Repository
public interface AmbienteRepository extends CrudRepository <Ambiente, Integer>{

}
