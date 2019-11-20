package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Permissao;

@Repository
public interface PermissaoLoginUsuarioRepository extends CrudRepository <Permissao, String>{

}
