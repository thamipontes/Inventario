

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.T008_SCHEMA_USUARIO;

@Repository
public interface T008_SCHEMA_USUARIORepository extends CrudRepository <T008_SCHEMA_USUARIO, Integer>{

}
