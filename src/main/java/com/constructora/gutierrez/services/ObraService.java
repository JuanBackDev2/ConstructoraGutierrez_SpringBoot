package com.constructora.gutierrez.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.entities.Obra;
public interface ObraService {

	public Page<ObraDTO> obtenerObras(Pageable pageable);
}
