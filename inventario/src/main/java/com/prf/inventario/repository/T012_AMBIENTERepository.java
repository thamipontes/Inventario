
package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.T012_AMBIENTE;

@Repository
public interface T012_AMBIENTERepository extends CrudRepository <T012_AMBIENTE, Integer>{

}
