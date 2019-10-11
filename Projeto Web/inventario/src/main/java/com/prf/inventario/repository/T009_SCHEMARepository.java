

package com.prf.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prf.inventario.model.Schema;

@Repository
public interface T009_SCHEMARepository extends CrudRepository <Schema, Integer>{

}
