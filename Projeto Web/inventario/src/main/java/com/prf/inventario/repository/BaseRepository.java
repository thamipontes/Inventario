package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Base;

@Repository
public interface BaseRepository extends CrudRepository <Base, Integer>{

}
