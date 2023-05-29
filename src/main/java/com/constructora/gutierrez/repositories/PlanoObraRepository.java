package com.constructora.gutierrez.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.entities.Plano;
import com.constructora.gutierrez.entities.PlanoObra;
import com.constructora.gutierrez.entities.CKeys.PlanoObraPK;
@Repository
public interface PlanoObraRepository extends PagingAndSortingRepository<PlanoObra,PlanoObraPK>{

	public Page<PlanoObra> findByObra(Obra obra, Pageable pageable);
	public void save(PlanoObra planoObra);
	public PlanoObra findByObraAndPlanoid(Obra obra,Plano plano);
	public void delete(PlanoObra planoObra);
	public Page<PlanoObra> findByPlanoid(Plano plano, Pageable pageable);
}
