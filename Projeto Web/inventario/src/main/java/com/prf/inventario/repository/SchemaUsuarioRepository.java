

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.SchemaUsuario;

@Repository
public interface SchemaUsuarioRepository extends CrudRepository <SchemaUsuario, Integer>{

}
