package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.PersonalDTO;
import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.entities.Personal;

public interface PersonalService {
	
	public PersonalDTO findById(String id);
	public Page<PersonalDTO> findAll(Pageable pageable);
	public	Page<PersonalObraDTO> obrasByPersonal(Pageable pageable,String id);
}
