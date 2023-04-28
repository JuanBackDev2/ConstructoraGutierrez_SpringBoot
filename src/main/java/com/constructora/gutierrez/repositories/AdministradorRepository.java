package com.constructora.gutierrez.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.constructora.gutierrez.entities.Administrador;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador,String> {

}
