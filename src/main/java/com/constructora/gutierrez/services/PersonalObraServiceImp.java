package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.entities.CKeys.PersonalObraPK;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.ObraRepository;
import com.constructora.gutierrez.repositories.PersonalObraRepository;
import com.constructora.gutierrez.repositories.PersonalRepository;
@Service
public class PersonalObraServiceImp implements PersonalObraService {

	@Autowired
	PersonalObraRepository PrRepository;
	
	@Autowired
	ObraRepository obraRepository;
	
	@Autowired
	PersonalRepository personalRepository;
	
	@Override
	public Page<PersonalObraDTO> obtenerPersonalObra(Pageable pageable,String id) {
		
		Obra obra = obraRepository.findById(id);
		
		Page<PersonalObra> personalObra = PrRepository.findByObra(obra, pageable);
		Page<PersonalObraDTO> poDTO = Helpers.mapPage(personalObra, PersonalObraDTO.class);
		
		return poDTO;
	}

	@Override
	public void registrarPersonalObra(PersonalObraDTO po, String obraId) {
		Personal personal = personalRepository.findById(po.getPersonal());
		Obra obra = obraRepository.findById(obraId);
		
		PersonalObraPK pk = new PersonalObraPK();
		pk.setObra(obraId);
		pk.setPersonalid(po.getPersonal());
		
		PrRepository.save(PersonalObra.builder()
									  .obra(obra)
									  .personal(personal)
									  .id(pk)
									  .diasTrabajados(po.getDiasTrabajados())
									  .build());
		//añadir 2 validaciones
		//1. que no exista ya el PersonalObra
		//2. que exista el personal
		
		//añadir registrar personal
	}
	

}
