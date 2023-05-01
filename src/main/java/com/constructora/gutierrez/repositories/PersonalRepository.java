package com.constructora.gutierrez.repositories;
import com.constructora.gutierrez.entities.Personal;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends PagingAndSortingRepository<Personal,String> {

	public Personal findById(String id);
}
