package com.constructora.gutierrez.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.constructora.gutierrez.entities.Obra;

@Repository
public interface ObraRepository extends PagingAndSortingRepository<Obra,String> {
	public Obra findById(String id);
	public void save(Obra obra);
	public void delete(Obra obra);
	public boolean existsById(String id);
}
