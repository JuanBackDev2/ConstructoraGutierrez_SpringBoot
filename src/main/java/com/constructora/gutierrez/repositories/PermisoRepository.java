package com.constructora.gutierrez.repositories;
import com.constructora.gutierrez.entities.Permiso;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends PagingAndSortingRepository<Permiso,String>{
	public void save(Permiso permiso);
	public void delete(Permiso permiso);
	public Permiso findById(String id);
}
