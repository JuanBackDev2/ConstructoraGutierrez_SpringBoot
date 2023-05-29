package com.constructora.gutierrez.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.constructora.gutierrez.entities.FacturaObra;
import com.constructora.gutierrez.entities.Obra;

@Repository
public interface FacturaObraRepository extends PagingAndSortingRepository<FacturaObra,String>{
	public Page<FacturaObra> findByObraId(Obra obra,Pageable pageable);
	public void save(FacturaObra factura);
	public FacturaObra findById(String id);
	public void delete(FacturaObra factura);
}
