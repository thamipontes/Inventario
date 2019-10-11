package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Inventario;

@Repository
public interface InventarioRepository extends CrudRepository <Inventario, String>{

}
