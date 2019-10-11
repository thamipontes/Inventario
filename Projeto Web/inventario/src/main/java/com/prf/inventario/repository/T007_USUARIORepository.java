

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Usuario;

@Repository
public interface T007_USUARIORepository extends CrudRepository <Usuario, Integer>{

}
