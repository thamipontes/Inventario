

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.DiscosServidor;

@Repository
public interface DiscosServidorRepository extends CrudRepository <DiscosServidor, Integer>{

}
