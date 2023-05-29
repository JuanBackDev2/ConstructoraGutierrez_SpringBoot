package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.PlanoDTO;

public interface PlanoService {

	public Page<PlanoDTO> obtenerPlanos(Pageable pageable);
	public void registrarPlano(PlanoDTO planoDTO);
	public PlanoDTO obtenerPlano(String id);
	public void editarPlano(String id,PlanoDTO planoDTO);
	public void eliminarPlano(String id);
	public boolean existsById(String id);
}
