package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Servidor;

@Repository
public interface ServidorRepository extends CrudRepository <Servidor, Integer>{

}
