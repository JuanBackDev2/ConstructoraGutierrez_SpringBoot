package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.TerrenoDTO;
import com.constructora.gutierrez.entities.Terreno;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.TerrenoRepository;

@Service
public class TerrenoServiceImp implements TerrenoService{
	
	@Autowired
	TerrenoRepository terrenoRepository;

	@Override
	public Page<TerrenoDTO> obtenerTerrenos(Pageable pageable) {
		
		Page<Terreno> terrenos = terrenoRepository.findAll(pageable);
		
		Page<TerrenoDTO> terrenosDTO = Helpers.mapPage(terrenos, TerrenoDTO.class);
		
		return terrenosDTO;
	}

	@Override
	public boolean existsById(String id) {
		return terrenoRepository.existsById(id);
	}

}
