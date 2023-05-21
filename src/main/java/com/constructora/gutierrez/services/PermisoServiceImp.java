package com.constructora.gutierrez.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PermisoDTO;
import com.constructora.gutierrez.entities.Permiso;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.PermisoRepository;

@Service
public class PermisoServiceImp implements PermisoService{
	
	@Autowired
	PermisoRepository permisoRepository;

	@Override
	public Page<PermisoDTO> findAll(Pageable pageable) {
		
		Page<Permiso> permisos = permisoRepository.findAll(pageable);
		Page<PermisoDTO> permisosDTO = Helpers.mapPage(permisos, PermisoDTO.class);
		return permisosDTO;
	}

	@Override
	public void registrarPermiso(PermisoDTO permisoDTO) {
		String uniqueID = UUID.randomUUID().toString();
		
		Permiso permiso = Helpers.modelmapper().map(permisoDTO, Permiso.class);
		permiso.setEstadopermiso("Activo");
		permiso.setPermisoid(uniqueID);
		
		permisoRepository.save(permiso);
	}

	@Override
	public void borrarPermiso(String id) {
		Permiso permiso = permisoRepository.findById(id);
		permisoRepository.delete(permiso);
		
	}

}
