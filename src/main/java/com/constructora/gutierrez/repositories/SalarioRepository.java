package com.constructora.gutierrez.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.constructora.gutierrez.entities.Salario;

@Repository
public interface SalarioRepository extends PagingAndSortingRepository<Salario,String> {
	public void save(Salario salario);
}
