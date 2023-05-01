package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PersonalDTO;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.PersonalRepository;

@Service
public class PersonalServiceImp implements PersonalService{
	
	@Autowired
	PersonalRepository personaRepository;

	@Override
	public PersonalDTO findById(String id) {
		
		Personal personal = personaRepository.findById(id);
		PersonalDTO personalDTO = Helpers.modelmapper().map(personal, PersonalDTO.class);
		
		return personalDTO;
	}

}
