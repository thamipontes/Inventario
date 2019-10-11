

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.T007_USUARIO;

@Repository
public interface T007_USUARIORepository extends CrudRepository <T007_USUARIO, Integer>{

}
