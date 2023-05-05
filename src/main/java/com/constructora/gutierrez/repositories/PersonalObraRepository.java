package com.constructora.gutierrez.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.entities.CKeys.PersonalObraPK;

@Repository
public interface PersonalObraRepository extends PagingAndSortingRepository<PersonalObra,PersonalObraPK> {

	public Page<PersonalObra> findByObra(Obra obra, Pageable pageable);
	public Page<PersonalObra> findByPersonal(Personal personal, Pageable pageable);
	public void save(PersonalObra po);
	
}
