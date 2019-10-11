package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.T001_SERVIDOR;

@Repository
public interface T001_SERVIDORRepository extends CrudRepository <T001_SERVIDOR, Integer>{

}
