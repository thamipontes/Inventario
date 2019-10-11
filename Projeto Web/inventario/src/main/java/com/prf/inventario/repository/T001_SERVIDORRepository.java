package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Servidor;

@Repository
public interface T001_SERVIDORRepository extends CrudRepository <Servidor, Integer>{

}
