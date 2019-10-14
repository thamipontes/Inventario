
package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Sgbd;

@Repository
public interface SgbdRepository extends CrudRepository <Sgbd, Integer>{

}
