package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PersonalDTO;
import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.PersonalObraRepository;
import com.constructora.gutierrez.repositories.PersonalRepository;

@Service
public class PersonalServiceImp implements PersonalService{
	
	@Autowired
	PersonalRepository personaRepository;
	
	@Autowired
	PersonalObraRepository personalObraRepository;
	
	@Autowired
	SalarioService salarioService;

	@Override
	public PersonalDTO findById(String id) {
		
		Personal personal = personaRepository.findById(id);
		PersonalDTO personalDTO = Helpers.modelmapper().map(personal, PersonalDTO.class);
		
		return personalDTO;
	}

	@Override
	public Page<PersonalDTO> findAll(Pageable pageable) {
		Page<Personal> personal = personaRepository.findAll(pageable);
		Page<PersonalDTO> personalDTO = Helpers.mapPage(personal, PersonalDTO.class);
		return personalDTO;
	}

	@Override
	public Page<PersonalObraDTO> obrasByPersonal(Pageable pageable, String id) {
		Personal personal = personaRepository.findById(id);
		Page<PersonalObra> obrasPersonal = personalObraRepository.findByPersonal(personal, pageable);
		Page<PersonalObraDTO> obrasPersonalDTO = Helpers.mapPage(obrasPersonal, PersonalObraDTO.class);
		return obrasPersonalDTO;
	}

	@Override
	public boolean existsById(String id) {
		return personaRepository.existsById(id);
	}

	@Override
	public void registrarPersonal(PersonalDTO personalDTO) {
		Personal personal = Helpers.modelmapper().map(personalDTO, Personal.class);
		personaRepository.save(personal);
		salarioService.registrarSalario(personalDTO);
	}

	@Override
	public void eliminarPersonal(String id) {
		Personal personal = personaRepository.findById(id);
		personaRepository.delete(personal);
		
	}

	@Override
	public void editarPersonal(String id, PersonalDTO personalDTO) {
		Personal personal = personaRepository.findById(id);
		personal.setNombre(personalDTO.getNombre());
		personal.setApellido(personalDTO.getApellido());
		personal.setCargo(personalDTO.getCargo());
		
		personaRepository.save(personal);
	}

}
