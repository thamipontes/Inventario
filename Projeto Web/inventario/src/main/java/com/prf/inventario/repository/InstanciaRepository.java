
package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Instancia;

@Repository
public interface InstanciaRepository extends CrudRepository <Instancia, Integer>{

}
