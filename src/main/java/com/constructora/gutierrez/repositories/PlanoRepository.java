package com.constructora.gutierrez.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.constructora.gutierrez.entities.Plano;

@Repository
public interface PlanoRepository extends PagingAndSortingRepository<Plano,String> {
	public void save(Plano plano);
	public Plano findById(String id);
	public void delete(Plano plano);
	public boolean existsById(String id);
	
}
