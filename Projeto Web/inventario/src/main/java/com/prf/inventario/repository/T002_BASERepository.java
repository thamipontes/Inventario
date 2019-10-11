package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Base;

@Repository
public interface T002_BASERepository extends CrudRepository <Base, Integer>{

}
