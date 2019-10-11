

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Sistema;

@Repository
public interface T004_SISTEMARepository extends CrudRepository <Sistema, Integer>{

}
