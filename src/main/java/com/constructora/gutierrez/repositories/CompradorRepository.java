package com.constructora.gutierrez.repositories;
import com.constructora.gutierrez.entities.Comprador;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends PagingAndSortingRepository<Comprador,String>{
	
	public Comprador findById(String id);
	public boolean existsById(String id);
	public void save(Comprador comprador);
	public void delete(Comprador comprador);
}
