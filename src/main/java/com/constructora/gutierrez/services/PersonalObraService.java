package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.entities.PersonalObra;


public interface PersonalObraService {

	public Page<PersonalObraDTO> obtenerPersonalObra(Pageable pageable,String id);
	public void registrarPersonalObra(PersonalObraDTO po,String obraId);
}
