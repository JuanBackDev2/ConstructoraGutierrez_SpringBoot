package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.ObraRepository;
import com.constructora.gutierrez.repositories.PersonalObraRepository;
@Service
public class PersonalObraServiceImp implements PersonalObraService {

	@Autowired
	PersonalObraRepository PrRepository;
	
	@Autowired
	ObraRepository obraRepository;
	
	@Override
	public Page<PersonalObraDTO> obtenerPersonalObra(Pageable pageable,String id) {
		
		Obra obra = obraRepository.findById(id);
		
		Page<PersonalObra> personalObra = PrRepository.findByObra(obra, pageable);
		Page<PersonalObraDTO> poDTO = Helpers.mapPage(personalObra, PersonalObraDTO.class);
		
		return poDTO;
	}
	

}
