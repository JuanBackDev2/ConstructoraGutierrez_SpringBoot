package com.constructora.gutierrez.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.constructora.gutierrez.entities.Terreno;

@Repository
public interface TerrenoRepository extends PagingAndSortingRepository<Terreno,String> {
	public Terreno findById(String id);
	public boolean existsById(String id);
	public void save(Terreno terreno);
	public void delete(Terreno terreno);

}
