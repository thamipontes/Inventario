
package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.T006_SGBD;

@Repository
public interface T006_SGBDRepository extends CrudRepository <T006_SGBD, Integer>{

}
