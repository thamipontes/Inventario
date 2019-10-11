
package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Sgbd;

@Repository
public interface T006_SGBDRepository extends CrudRepository <Sgbd, Integer>{

}
