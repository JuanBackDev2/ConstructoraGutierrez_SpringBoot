package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.constructora.gutierrez.dtos.PermisoDTO;


public interface PermisoService {

	public Page<PermisoDTO> findAll(Pageable pageable);
	public void registrarPermiso(PermisoDTO permisoDTO);
	public void borrarPermiso(String id);
}
