

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, Integer>{

}
