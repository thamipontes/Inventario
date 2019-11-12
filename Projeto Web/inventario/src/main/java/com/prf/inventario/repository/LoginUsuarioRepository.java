

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.LoginUsuario;

@Repository
public interface LoginUsuarioRepository extends CrudRepository <LoginUsuario, String>{

}
