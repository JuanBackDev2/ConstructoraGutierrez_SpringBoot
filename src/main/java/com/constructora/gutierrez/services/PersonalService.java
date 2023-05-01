package com.constructora.gutierrez.services;

import com.constructora.gutierrez.dtos.PersonalDTO;
import com.constructora.gutierrez.entities.Personal;

public interface PersonalService {
	
	public PersonalDTO findById(String id);
}
